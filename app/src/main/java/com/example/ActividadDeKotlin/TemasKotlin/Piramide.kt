package com.example.ActividadDeKotlin.TemasKotlin

fun main() {
    var piramide:Int

    do {
        print("Ingresa un numero (ingresa 0 para salir): ")
        val entrada = readln()?.toInt()

        if (entrada == 0) {
            println("Saliendo del programa")
            break
        }

        if (entrada == null || entrada < 0) {
            println("Entrada no valida. Por favor, ingrese un numero entero no negativo.")
            continue
        }

        piramide = entrada

        var filaActual = 1
        do {
            var asteriscos = 1 * filaActual
            do {
                print("*")
                asteriscos--
            } while (asteriscos > 0)

            println()

            filaActual++
        } while (filaActual <= piramide)

    } while (true)
}