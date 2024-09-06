###############################################################################
print("Alicia Cides Berrocal - 2 bach B")

def calcular_media():
    nota_1 = int(input("Introduzca la primera nota"))
    nota_2 = int(input("Introduzca la segunda nota"))
    nota_3 = int(input("Introduzca la tercera nota"))
    if nota_1 < 4 or nota_2 < 4 or nota_3 < 4:
        print("Ha suspendido")
    else:
        print((nota_1 + nota_2 + nota_3) / 3)


def calcular_mayor():
    num_1 = int(input("Introduzca el primer número entero"))
    num_2 = int(input("Introduzca el segundo número entero"))
    num_3 = int(input("Introduzca el tercer número entero"))
    print(max([num_1, num_2, num_3]))


def muestra_nombre(lista_alumnos):
    nombre_alumno = input("Introduzca el nombre")
    if nombre_alumno in lista_alumnos:
        print("El alunmo ya esta en la lista de alumnos")
    else:
        lista_alumnos.append(nombre_alumno)


def muestra_lista(lista_alumnos):
    for alumno in lista_alumnos:
        print(alumno + "\n")


def guarda_lista(lista_alumnos, nombre_archivo):
    with open(nombre_archivo, mode="w") as f:
        f.writelines(lista_alumnos)

def recupera_lista(nombre_archivo):
    with open(nombre_archivo, mode="r") as f:
        lista = f.readlines()
    return lista

def calcula_matricula(lista_alumnos):
    print(len(lista_alumnos) * 250)

def comprueba_grupos(lista_alumnos, num_integrantes):
    if len(lista_alumnos)%num_integrantes == 0:
        print("Se pueden formar grupos completos")
    else:
        print("No se pueden formar grupos completos")


lista_alumnos = []
nombre_archivo = "alumnos.txt"
fin = False
while not fin:
    print("\nMenú:")
    print("1) Calcular media de tres notas")
    print("2) Encontrar el número mayor")
    print("3) Verificar alumno en lista")
    print("4) Mostrar lista de alumnos")
    print("5) Guardar lista de alumnos")
    print("6) Recuperar lista de alumnos")
    print("7) Calcular total de matrículas")
    print("8) Verificar grupos")
    print("0) Salir")
    opcion = int(input("Introduzca una opción"))
    if opcion == 1:
        calcular_media()
    elif opcion == 2:
        calcular_mayor()
    elif opcion == 3:
        muestra_nombre(lista_alumnos)
    elif opcion == 4:
        muestra_lista(lista_alumnos)
    elif opcion == 5:
        guarda_lista(lista_alumnos, nombre_archivo)
    elif opcion == 6:
        lista_alumnos = recupera_lista(nombre_archivo)
    elif opcion == 7:
        calcula_matricula(lista_alumnos)
    elif opcion == 8:
        num_integrantes = int(input("Introduzca el número de alumnos por grupo"))
        comprueba_grupos(lista_alumnos, num_integrantes)
    elif opcion == 0:
        fin = True
