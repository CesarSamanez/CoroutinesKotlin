package com.example.fundamentoscorutinas

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    // globalScope()
    suspendFun()

    readLine()
}

// Global Scopes
fun globalScope() {
    newTopic("Global Scope")
    /*
        Global Scope permite que la corutina este activa mientras
        no finalice el programa
     */
    GlobalScope.launch {
        startMsg()
        delay(someTime())
        println("My coroutine...")
        endMsg()
    }
}

fun startMsg() {
    println("Comenzando corutina - ${Thread.currentThread().name} -")
}

fun endMsg() {
    println("Finalizando corutina - ${Thread.currentThread().name} -")
}

// Suspend Functions
fun suspendFun(){
    newTopic("Suspend")
    Thread.sleep(someTime())
    delay(someTime())
}