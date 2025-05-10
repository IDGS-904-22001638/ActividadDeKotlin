package com.example.ActividadDeKotlin.TemasKotlin

fun main() {
    var continuar = true

    do {
        println("\nOperaciones Basicas")
        println("Seleccione una operacion:")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicacion")
        println("4. Division")
        println("5. Salir")
        print("Ingrese su opcion: ")

        val opcion = readln()

        when (opcion) {
            "1" -> Sum()
            "2" -> Res()
            "3" -> Mult()
            "4" -> Div()
            "5" -> {
                continuar = false
                println("Saliendo del programa")
            }
            else -> println("Opción no valida. Por favor, ingrese un numero entre 1 y 5.")
        }

    } while (continuar)
}

fun obtenerNumeros(): Pair<Double, Double>? {
    print("Ingrese el primer numero: ")
    val numero1 = readln().toDouble()
    print("Ingrese el segundo numero: ")
    val numero2 = readln().toDouble()

    if (numero1 == null || numero2 == null) {
        println("Entrada de numero no valida. Por favor, ingrese numeros validos.")
        return null
    }
    return Pair(numero1, numero2)
}

fun Sum() {
    val numeros = obtenerNumeros() ?: return
    val resultado = suma(numeros.first, numeros.second)
    println("El resultado de la suma es: $resultado")
}

fun Res() {
    val numeros = obtenerNumeros() ?: return
    val resultado = resta(numeros.first, numeros.second)
    println("El resultado de la resta es: $resultado")
}

fun Mult() {
    val numeros = obtenerNumeros() ?: return
    val resultado = multiplicacion(numeros.first, numeros.second)
    println("El resultado de la multiplicación es: $resultado")
}

fun Div() {
    val numeros = obtenerNumeros() ?: return
    val resultado = division(numeros.first, numeros.second)

    if (resultado != null) {
        println("El resultado de la división es: $resultado")
    } else {
        println("Error: División entre cero")
    }
}

fun suma(a: Double, b: Double): Double = a + b
fun resta(a: Double, b: Double): Double = a - b
fun multiplicacion(a: Double, b: Double): Double = a * b
fun division(a: Double, b: Double): Double? = if (b != 0.0) a / b else null