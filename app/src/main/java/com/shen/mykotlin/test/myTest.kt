//--------------------包--------------------
//目录与包的结构无需匹配
package com.shen.mykotlin

import com.shen.mykotlin.test.Customer
import java.io.File

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
var x = 5 // 自动推断出 `Int` 类型
//x += 1
val PI = 3.14
//var x = 0

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
        2 -> "www"
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        is Short -> "short"
        !is Int -> "Not a int"
        else -> "Unknown"

    }

fun foo(a: Int = 0, b: String = "") {
    print("sum of $a and $b is ")
}

fun String.spaceToCamelCase(): String {
    return (toString() + " space ")
}


object Resource {
    var name = "Name"
}

fun test() {
    val result = try {
        Integer.parseInt("")
    } catch (e: ArithmeticException) {
        throw IllegalStateException(e)
    }
// 使用 result
}

fun arrayOfMinusOnes(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

fun transform(color: String): Int = when (color) {
    "Red" -> 0
    "Green" -> 1
    "Blue" -> 2
    else -> throw IllegalArgumentException("Invalid color param value")
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
        println(item)
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
    if (x in 1..y + 1) {
        println("fits in range")
    }

    items
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }

    val str = StringBuffer("ddddd")

    val customer = Customer("name", "email", "email1")

    val positives = items.filter { it.startsWith("a") }

    val map = mapOf("a" to 1, "b" to 2, "c" to 3)
    for ((k, v) in map) {
        println("$k -> $v")
    }
    println(map["key"])

    val p by lazy {
        "a" + "b" + "cd"
    }

    println(p.spaceToCamelCase())

    val res = Resource
    println(res.name)
    res.name = "ddd"
    println(res.name)

    val files = File("Test").listFiles()
    println(files?.size)
    println(files?.size ?: "empty")

    val args = null
    args?.let {
        println(items.firstOrNull() ?: "")
    }

//    val email = map["email"] ?: throw IllegalStateException("Email is missing!")

    val max = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }

    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }

    val array = arrayOf("a", "b", "c")
    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }

    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // 非局部直接返回到 foo() 的调用者
        print(it)
    }
    println("this point is unreachable")

    InitOrderDemo("hello")
    Constructors(2)

    val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
    println(sumLambda(1, 2))
}

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }
}

fun vars(vararg v: Int) {
    for (vt in v) {
        print(vt)
    }
}