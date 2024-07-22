"""Indica y justifica qué tipo de datos de los que hemos estudiado utilizarías para representar 
lo siguiente:
1. El precio de una barra de pan.
2. El nombre de una constelación.
3. El DNI de una persona.
4. La cantidad ovejas que hay en un rebaño.
5. La matrícula de un coche.
6. La distancia recorrida por un avión durante un vuelo.
7. La velocidad media de una motocicleta.
8. La cantidad de calorías que tiene un yogurt.
9. La fecha de nacimiento de una persona.
10. El signo del zodíaco de una persona.
"""
precio_pan = 1.5
nombreConstelacion = "Sagitario"
dni = '3847393E'
lista = [1,2,3,4]
# Tuplas
coordenadas = (3, 5)
# Diccionarios
estudiante = {'nombre': 'María', 'edad': 20, 'curso': 'Python'}

def saludar():
    print("hola mundo")

if __name__ == "__main__": #Comúnmente utilizado en scripts de Python para separar 
                           #la lógica de ejecución del código reusable.
    saludar()
    print (precio_pan)
    print (nombreConstelacion)
    print (lista)
