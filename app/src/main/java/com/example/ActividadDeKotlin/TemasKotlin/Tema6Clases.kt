package com.example.ActividadDeKotlin.TemasKotlin

class usuarios(){
    val materia:String=""
}

class usuarios2(val id:Int, val nombre:String){
    val materia:String=""
    fun hola(){
        println("Hola")
        println("Hola")
    }
}

fun main(){
    val alumno = usuarios()
    val alumno2 = usuarios2(1, "Carlos")

    println(alumno2.id)
    println(alumno2.nombre)
    alumno2.hola()
}