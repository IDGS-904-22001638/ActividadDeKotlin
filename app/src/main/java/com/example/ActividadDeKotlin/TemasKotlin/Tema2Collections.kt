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
    val readOnlyFiguras = listOf("cuadrado", "triangulo", "circulo")
    println(readOnlyFiguras)
    println("La primera figura es ${readOnlyFiguras[0]}")
    println("EL primer elemento es ${readOnlyFiguras.first()}")
    println("NUmero de elmentos ${readOnlyFiguras.count()} itemes")
    println("Circulo" in readOnlyFiguras)
    println(readOnlyFiguras)
    //ReadOnlyFiguras.add("pentagono)
    var figura: MutableList<String> = mutableListOf("eventos", "trinagulo2", "circulo2")
    println(figura)
    figura.add("pentagono2")
    println(figura)
    figura.add("cuadrado2")
    println(figura)
}


