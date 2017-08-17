package algorithms

import java.util.*

/**
 * description Simple sort algorithms
 * author Melo Chan
 * date 2017/8/16
 * version 0.0.0.1
 */

fun main(vararg args: String) {
    val array = generateArray(10000)

    test(DefaultSort(array.copyOf()))
    test(SelectionSort(array.copyOf()))
    test(InsertionSort(array.copyOf()))
    test(ShellSort(array.copyOf()))
}

class ShellSort<T : Comparable<T>>(array: Array<T>) : Sort<T>(array) {

    override fun sort() {
        if (array.size > 1000000) return

        var shell = 1
        while (shell < array.size / 3) shell = shell * 3 + 1
        while (shell >= 1) {
            (shell until array.size).forEach outer@ {
                (it downTo shell step shell).forEach {
                    if (array[it] < array[it - shell]) exchange(it, it - shell)
                    else return@outer
                }
            }

            shell /= 3
        }
    }
}

class InsertionSort<T : Comparable<T>>(array: Array<T>) : Sort<T>(array) {

    override fun sort() {
        if (array.size > 10000) return

        (1 until array.size).forEach outer@ {
            (it downTo 1).forEach {
                if (array[it] < array[it - 1]) exchange(it, it - 1)
                else return@outer
            }
        }
    }
}

class SelectionSort<T : Comparable<T>>(array: Array<T>) : Sort<T>(array) {

    override fun sort() {
        if (array.size > 10000) return

        (0 until array.size).forEach {
            var index = it
            (it until array.size).forEach { if (array[it] < array[index]) index = it }
            exchange(it, index)
        }
    }
}

class DefaultSort<T : Comparable<T>>(array: Array<T>) : Sort<T>(array) {

    override fun sort() {
        if (array.size > 10000000) return

        array.sort()
    }
}

abstract class Sort<T : Comparable<T>>(protected val array: Array<T>) {

    private var countTime: Long = 0

    fun sortWithCounter() {
        val before = System.currentTimeMillis()
        sort()
        countTime = System.currentTimeMillis() - before
    }

    protected abstract fun sort()

    fun exchange(left: Int, right: Int) {
        val temp = array[left]
        array[left] = array[right]
        array[right] = temp
    }

    fun print() {
        if (array.size > 500) return

        array.forEach { print(it.toString().plus(" ")) }
        println("")
    }

    fun isSorted(): Boolean = (1 until array.size).none { array[it] < array[it - 1] }

    fun getCountTime(): Long = countTime
}

fun <T : Comparable<T>> test(sort: Sort<T>) {
    sort.apply {
        println("start test for ${javaClass.simpleName}...")
        print()
        sortWithCounter()
        print()
        println(if (isSorted()) "succeed" else "fail")
        println("${getCountTime()}ms\ncomplete\n")
    }
}

fun generateArray(size: Int): Array<Int> {
    val random = Random()
    return Array(size, { random.nextInt() })
}