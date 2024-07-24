#Realiza un programa en Java que simule la cafetería de una facultad.
#El programa pedirá los siguientes datos al usuario:
#   1. Cantidad de cafés que se van a tomar.
#   2. Cantidad de tostadas que se van a tomar.
#   3. Cantidad de zumos de naranja natural que se van a tomar.
#El usuario deberá introducir la cantidad de cada uno de estos productos, pudiendo ser 0 si no desea tomar alguno de ellos.
#El programa deberá calcular y mostrar cuánto deberá el pagar el usuario, siendo los precios los siguientes:
#   1. Precio de 1 café: 1.1€
#   2. Precio de 1 tostada: 1.5€
#   #3. Precio de 1 zumo de naranja natural: 2€

#entrada por teclado
numero_cafes = int(input("Cuantos cafes quieres tomar? "))
numero_tostadas = int(input("Cuantas tostadas quieres tomar? "))
numero_zumos = int(input("Cuantos zumos quieres tomar? "))

#Cálculo del precio
precio_cafe = numero_cafes*1.1
precio_tostadas = numero_tostadas*1.5
precio_zumos = numero_zumos*2
precio_total = precio_cafe + precio_tostadas + precio_zumos

print("El precio total a pagar es: " + str(precio_total))


