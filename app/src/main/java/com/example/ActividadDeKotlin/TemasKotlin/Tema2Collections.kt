package com.example.ActividadDeKotlin.TemasKotlin

/*
    List
    MutableList
    MutableSet
    Map
    MutableMap



val readOnlyFiguras = listOf("Cuadrado","Trinagulo","Circulo")
println(readOnlyFiguras)


var figura: mutableFiguras = mutableListOf("Cuadrado","Trinagulo","Circulo")
val readOnlyFiguras = listOf("Cuadrado","Triangulo","Circulo")
val mutableFigura :List<String> = figura

val frutas = setOf("Manzana","Banana","Naranja")
val frutas mutableSetOf("Manzana","Banana","Naranja")

val coches = mapOf("uno" to 1, "dos" to 2, "tres" to 3)
println(coches)
val coches2 = mutableMapOf("uno" to 1, "dos" to 2, "tres" to 3)
println(coches2)

 */

fun main(){
    val readOnlyFiguras = ListOf("Cuadrado","Trinagulo","Circulo")
    println(readOnlyFiguras)
    println("La primera figura es ${readOnlyFiguras}")
}


