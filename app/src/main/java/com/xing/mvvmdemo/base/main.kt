package com.xing.mvvmdemo.base

import java.util.jar.Attributes



fun main() {
    val response = Response(null, 2222, "cccccc")
    println(response)

    val cc = { a: Int, b: Int -> a + b }
    val dd = compute { a: Int, b: Int -> a + b }


    2 shl 2

}

fun MainJava.test(): String {
    val cc = { name }
    return "cccc"
}


fun test(): String {
    return "string:"
}

fun getName(): String {
    return "name"
}

inline fun ccc(noinline block1: () -> Unit, block2: () -> String) {

}


inline fun compute(noinline block: (a: Int, b: Int) -> Int): Int {
    return block(2, 3)
}

fun tes(aa: () -> String, cc: Int): String {
    return aa.invoke()
}
