import os.path
from pathlib import Path

import cv2 as cv
import fitz
from PIL import Image, ImageOps
from PyPDF2 import PdfMerger
from deep_translator import GoogleTranslator
from pdf2image import convert_from_path
from pytesseract.pytesseract import image_to_string, Output, image_to_data, image_to_osd, TesseractError
from reportlab.lib.units import mm
from reportlab.pdfgen.canvas import Canvas
from scipy.ndimage import rotate

from source.excepciones import NoTexto14

Image.MAX_IMAGE_PIXELS = 4617416050


def get_text_from_image(img_path: str | bytes, lang="spa+eng") -> str:
    """
    Función que devuelve el texto que encuentre en una imagen
    :param img_path: ruta de la imagen
    :param lang: idioma a usar para el ocr
    :return: str con el texto encontrado

    .. warning:: Para usar los distintos lenguajes es necesario incluir los archivos de entrenamiento en la carpeta  tessdata dentro de la ruta de instalación de tesseract
    """
    with Image.open(img_path) as img:
        imggray = ImageOps.grayscale(img)
        text = image_to_string(imggray, lang=lang, config='--oem 1')
    return text


def generate_pdf_from_images(input_folder: str | bytes, pdf_path: str | bytes):
    """
    Crea un pdf a partir de las imágenes de una carpeta
    :param input_folder: ruta a la carpeta donde se encuentran las imagenes
    :param pdf_path: ruta del pdf a escribir
    """
    images = []
    for f in os.listdir(input_folder):
        if '.png' not in f:
            continue
        images.append(os.path.join(input_folder, f))
    doc = fitz.open()
    for image in images:
        page = doc.new_page()
        page.insert_image(page.rect, filename=image)
    doc.ez_save(pdf_path)


def generate_images_from_pdf(pdf_path: str | bytes, output_folder: str | bytes):
    """
    Crea una imagen por página del pdf de entrada
    :param pdf_path: ruta del pdf a transformar
    :param output_folder: carpeta dónde guardar las imágenes

    .. warning:: Es necesario incluir en el path los binarios de poppler
    """
    images = convert_from_path(pdf_path, dpi=400)
    pdf_name = Path(pdf_path).name.replace('.pdf', '')
    for i, image in enumerate(images, start=1):
        image.save(os.path.join(output_folder, f"{pdf_name}_pagina_{i}.png"))


def get_text_from_other_reasons(img_path: str | bytes) -> tuple[list, str]:
    """
    Busca el texto del campo 14.- Otros motivos/Other reasons de la plantilla de santander
    :param img_path: ruta de la imagen que contiene la planitlla
    :return: tupla con una lista de las coordenadas de los textos encontrados y el texto del campo
    """
    img_rgb = cv.imread(img_path)
    img_gray = cv.cvtColor(img_rgb, cv.COLOR_BGR2GRAY)
    results = image_to_data(img_gray, output_type=Output.DICT)
    coordenadas = []
    encontrado_motivo = False
    texto_a_traducir = ""
    for i in range(0, len(results["text"])):
        x = results["left"][i]
        y = results["top"][i]
        w = results["width"][i]
        h = results["height"][i]
        text = results["text"][i]
        if "14.-" in text or encontrado_motivo:
            coordenadas.append({'x': x, 'y': y, 'w': w, 'h': h, 'text': text})
            encontrado_motivo = True
            texto_a_traducir += " " + text
        if "Firma del Titular" in texto_a_traducir:
            break
    if "14.-" not in texto_a_traducir:
        raise NoTexto14
    indice_start = [i for i, contenido in enumerate(coordenadas) if 'reasons.' in contenido['text']][0]
    indice_fin = [i for i, contenido in enumerate(coordenadas) if 'Firma' in contenido['text']][0]
    coordenadas = coordenadas[indice_start + 1: indice_fin]
    coordenadas = [c for c in coordenadas if c['text']]
    texto_a_traducir = texto_a_traducir.split('reasons.')[1]
    texto_a_traducir = texto_a_traducir.split('Firma')[0]
    return coordenadas, texto_a_traducir


def translate_text(text: str) -> str:
    """
    Traduce el texto que se indique a inglés
    :param text: texto a traducir
    :return: texto traducido
    """
    text_translated = GoogleTranslator(source='spanish', target='english').translate(text.replace('-\n', ''))
    if text_translated:
        text_translated = text_translated.replace('business', 'merchant')
    return text_translated


def correct_text_rotation(image_path: str):
    """
    Rota la imagen para dejarla con la orientación necesaria
    :param image_path: ruta de la imagen a leer
    """
    image = cv.imread(image_path)
    rgb = cv.cvtColor(image, cv.COLOR_BGR2RGB)
    try:
        results = image_to_osd(rgb, output_type=Output.DICT)
        if results['orientation_conf'] >= 15:
            if 180 < results['orientation'] <= 360:
                angle = -results['rotate']
            elif 180 > results['orientation'] > 0:
                angle = results['rotate']
            else:
                angle = 0
            img_rotated = rotate(input=image, angle=angle)
            cv.imwrite(filename=image_path, img=img_rotated)
        else:
            raise TesseractError(status=1, message="No se ha superado el umbral de confianza")
    except TesseractError as te:
        raise te


def generate_pdf_blank_text(pdf_path: str | bytes, text_list: list[str]):
    """
    Genera un pdf en blanco con el texto que se introduzca
    :param pdf_path: ruta del pdf a escribir
    :param text_list: lista con el texto a escribir en el pdf
    """
    canvas = Canvas(pdf_path, pagesize=(210 * mm, 297 * mm))
    text_obj = canvas.beginText(0.7 * mm, 275 * mm)
    text_obj.setFont('Helvetica', size=13)
    for line in text_list:
        text_obj.textLine(line)
    canvas.drawText(text_obj)
    canvas.save()


def merge_pdfs(pdf_result_path: str | bytes, pdfs_to_merge: list[str | bytes] = None, input_path: str = None):
    """
    Crea un único pdf a partir de varios
    :param pdf_result_path: ruta del pdf resultante
    :param pdfs_to_merge: lista de rutas de los pdfs a escribir
    :param input_path: ruta de la carpeta de la que leer todos los pdfs a unir
    """
    merger = PdfMerger()
    if not pdfs_to_merge and input_path:
        for pdf in os.listdir(input_path):
            if '.pdf' in pdf:
                merger.append(os.path.join(input_path, pdf))
    else:
        for pdf in pdfs_to_merge:
            merger.append(pdf)
    merger.write(pdf_result_path)


def write_text_on_image(image_path: str | bytes, text: str, coordenadas: list[dict], max_len_line: int = 76):
    """
    Escribe texto en una imagen a partir de unas coordenadas
    :param max_len_line: longitud máxima de la línea a escribir para que sea legible
    :param image_path: ruta de la imagen a escribir
    :param text: texto a escribir
    :param coordenadas: coordenadas a las que se les suma un offset para escribir el texto
    """
    imagen = cv.imread(image_path)
    if len(text) > max_len_line:
        text = [text[i: i + max_len_line].strip() for i in range(0, len(text), max_len_line)]
        for indice, t in enumerate(text):
            cv.putText(img=imagen, text=t, org=(coordenadas[0]['x'], coordenadas[-1]['y'] + 176 + indice * 75),
                       fontFace=cv.FONT_ITALIC, fontScale=2.0, color=(0, 0, 0), thickness=3)
    else:
        cv.putText(img=imagen, text=text.strip(), org=(coordenadas[0]['x'], coordenadas[-1]['y'] + 176),
                   fontFace=cv.FONT_ITALIC, fontScale=2.0, color=(0, 0, 0), thickness=3)
    cv.imwrite(image_path, imagen)


def prepare_text_pdf(text: str, max_len_lines: int, max_lines_page: int) -> list[list[str]]:
    """
    Prepara el texto para que se pueda generar el pdf y sea legible
    :param text: texto a escribir
    :param max_len_lines: longitud máxima de cada línea
    :param max_lines_page:  número máximo de líneas por página
    :return: lista de líneas a escribir
    """
    text_lines = text.split('\n')
    pdf_text = []
    for line in text_lines:
        if len(line) > max_len_lines:
            new_lines = [line[i: i + max_len_lines] for i in range(0, len(line), max_len_lines)]
            for new_line in new_lines:
                pdf_text.append(new_line)
        else:
            pdf_text.append(line)
    pdf_text = [pdf_text] if len(pdf_text) <= max_lines_page else \
        [pdf_text[t: t + max_lines_page] for t in range(0, len(pdf_text), max_lines_page)]
    return pdf_text