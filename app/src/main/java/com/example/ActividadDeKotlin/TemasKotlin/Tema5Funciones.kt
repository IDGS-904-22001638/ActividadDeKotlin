package com.example.ActividadDeKotlin.TemasKotlin

fun saludo(){
    println("Hola Mundo")
}

fun suma(a:Int, b:Int){
    println("La suma de $a + $b es ${a+b}")
}

fun resta(a:Int, b:Int):Int{
    return a-b
}

fun main(){
    saludo()
    suma(2, 3)
    println("La resta de 2-3 es ${resta(2, 3)}")
}

/*
Actividad 1:Una calculadora basica con menu usando if-when o do-while
Actividad 2:Una piramide de asteriscos dependiendo del numero ingresado(si se ingresa 0 la aplicacion se cerrara)
            solo usando do/while
Actividad 3:Una calculadora pero de la formula general usando if-when o do-while
*/