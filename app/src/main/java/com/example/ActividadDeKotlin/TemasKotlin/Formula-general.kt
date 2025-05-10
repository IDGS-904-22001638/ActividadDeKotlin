package com.example.ActividadDeKotlin.TemasKotlin

fun main() {
    println("\nCalculadora de la formula general")
    println("(Para ecuaciones como ax² + bx + c = 0)")

    var continuar = true

    while (continuar) {
        println("\nIngresa los valores: ")

        print("a = ")
        val a = readln().toDouble()
        print("b = ")
        val b = readln().toDouble()
        print("c = ")
        val c = readln().toDouble()

        if (a == 0.0) {
            println("Error: 'a' no puede ser cero")
        } else {
            val d = b*b - 4*a*c
            println("\nDiscriminante = $d")

            if (d > 0) {
                val raiz = raizCuadrada(d)
                val x1 = (-b + raiz)/(2*a)
                val x2 = (-b - raiz)/(2*a)
                println("Dos soluciones reales:")
                println("x1 = $x1")
                println("x2 = $x2")
            } else if (d == 0.0) {
                val x = -b/(2*a)
                println("Una solución real:")
                println("x = $x")
            } else {
                val raizPositiva = raizCuadrada(-d)
                val real = -b/(2*a)
                val imag = raizPositiva/(2*a)
                println("Soluciones complejas:")
                println("x1 = $real + ${imag}i")
                println("x2 = $real - ${imag}i")
            }
        }

        print("\n¿Quieres resolver otra ecuación? (si/no): ")
        if (readln() != "si") {
            continuar = false
        }
    }

    println("\nSaliendo del programa")
}

fun raizCuadrada(num: Double): Double {
    var r = num / 2.0
    for (i in 1..10) {
        r = (r + num/r)/2
    }
    return r
}