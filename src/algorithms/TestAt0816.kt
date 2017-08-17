package algorithms

import java.util.*

/**
 * description TODO
 * author Melo Chan
 * date 2017/8/16
 * version 0.0.0.1
 */

fun main(vararg args: String) {
    // test for binary search
    println(binarySearch(5, arrayOf(0, 1, 4, 5, 7)))

    println(2.0e-6 * 100000000.1)

    println(if (testInputIntegers()) "equal" else "not equal")

    println(testTwoDouble(0.6, 0.9999999999))

    println(oct2bin(31))

    printBooleanArray(arrayOf(arrayOf(true, false, true, true, false), arrayOf(false, true, true, false, true), arrayOf(true, false, false, false, true)))
}

fun binarySearch(aim: Int, array: Array<Int>): Int {
    sort(array)

    var right = array.size
    var left = 0

    while (left <= right) {
        val middle = (left + right) / 2

        when {
            aim < array[middle] -> right = middle - 1
            aim > array[middle] -> left = middle + 1
            else -> return middle
        }
    }

    return -1
}

fun sort(array: Array<Int>) {

}

fun testInputIntegers(): Boolean {
    val scanner = Scanner(System.`in`)
    println("input an integer please:")
    val first = scanner.nextInt()
    println("input an integer please:")
    val second = scanner.nextInt()
    println("input an integer please:")
    val third = scanner.nextInt()
    scanner.close()
    return first == second && first == third
}

fun testTwoDouble(left: Double, right: Double): Boolean {
    return left > 0 && left < 1 && right > 0 && right < 1
}

fun oct2bin(src: Int): String {
    var i = src

    val builder = StringBuilder()
    while (i > 0) {
        builder.append(i % 2)
        i /= 2
    }

    return builder.toString()
}

fun printBooleanArray(array: Array<Array<Boolean>>) {
    for (itemArray in array) {
        for (item in itemArray) print(if (item) "*" else " ")
        println("")
    }
}