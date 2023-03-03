package com.example.fundamentoscorutinas

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.random.Random

private const val SEPARATOR = "==============="
fun newTopic(topic: String) {
    println("\n$SEPARATOR $topic $SEPARATOR\n")
}

fun main() {
    // lambda()
    // threads()
    coroutinesVsThreads()
}

// Lambda's function
fun lambda() {
    newTopic("Lambdas")
    multilambda(2, 4) { result ->
        println(result)
    }
    reslambda(15, 4) { result ->
        println(result)
    }
}

fun multilambda(x: Int, y: Int, callback: (result: Int) -> Unit) {
    callback(x * y)
}

fun reslambda(x: Int, y: Int, callback: (result: Int) -> Unit) {
    callback(x - y)
}

// Thread's function
fun threads() {
    newTopic("Threads")
    println("Thread ${multiThread(5, 3)}")
    multiThreadLambda(2, 5) { result ->
        println("Thread & Lambda $result")
    }
}

fun multiThread(x: Int, y: Int): Int {
    var result = 0

    // Se ejecuta en segundo plano
    thread {
        Thread.sleep(someTime())
        result = x * y
    }

    // No es eficiente, porque el limite se define por el usuario
    // Thread.sleep(2_100)
    return result
}

// Thread & Lambda
fun multiThreadLambda(x: Int, y: Int, callback: (result: Int) -> Unit) {
    var result = 0
    thread {
        Thread.sleep(someTime())
        result = x * y
        callback(result)
    }
}

fun someTime(): Long = Random.nextLong(500, 2_000)

// Coroutine's function
fun coroutinesVsThreads() {
    newTopic("Coroutines vs Threads")

    // Memory overflow
    /*
    (1..1_000_000).forEach{
        thread{
            Thread.sleep(someTime())
            println("*")
        }
    }
    */

    // Efficient coroutine
    runBlocking {
        (1..1_000_000).forEach {
            launch {
                delay(someTime())
                print("*")
            }
        }
    }


}

