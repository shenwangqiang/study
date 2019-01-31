//--------------------包--------------------
//目录与包的结构无需匹配
package com.shen.mykotlin

import android.graphics.Rect
import androidx.constraintlayout.solver.widgets.Rectangle

//--------------------函数--------------------
//带有两个 Int 参数、返回 Int 的函数：
fun sum(a: Int, b: Int): Int {
    return a + b
}

//将表达式作为函数体、返回值类型自动推断的函数：
fun sum1(a: Int, b: Int) = a + b

//函数返回无意义的值
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

//Unit 返回类型可以省略
fun printSum1(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

//--------------------定义变量--------------------
//定义只读局部变量使用关键字 val 定义。只能为其赋值一次。
val a: Int = 1  // 立即赋值
val b = 2   // 自动推断出 `Int` 类型
//val c: Int  // 如果没有初始值类型不能省略
//c = 3       // 明确赋值
//var x = 5 // 自动推断出 `Int` 类型
//x += 1
val PI = 3.14
var x = 0

/*
 * //ddd
 * /*
 * 222222
 * */
 */
fun addX() {
    x += 1
}

//ddddd

var int = 1
// 模板中的简单名称：
val s1 = "a is $int"

var int1 = 2
// 模板中的任意表达式：
val s2 = "${s1.replace("is", "was")}, but now is $int"

// 使用条件表达式
fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun parseInt(str: String): Int? {
    try {
        return Integer.parseInt(str)
    } catch (e: Exception) {
        return null
    }
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` 在该条件分支内自动转换成 `String`
        return obj.length
    }

    // 在离开类型检测分支后，`obj` 仍然是 `Any` 类型
    return null
}

fun describe(obj: Any): String =
    when (obj) {
        2          -> "www"
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }

fun main() {
    print("sum of 3 and 5 is ")
    println(sum(3, 5))
    println("sum of 19 and 23 is ${sum1(12, 24)}")
    println("sum of 2 and 13 is ${printSum(2, 13)}")
    println(" ${addX()}")
    println(" ${parseInt("")}")
    println(" ${getStringLength("12234")}")

    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println( item )
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    println(" ${describe(12234L)}")

    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println("fits in range")
    }

    items
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }

    val str = StringBuffer("ddddd")
}