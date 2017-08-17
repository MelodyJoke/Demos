package algorithms

import java.util.*

/**
 * description Simple sort algorithms
 * author Melo Chan
 * date 2017/8/16
 * version 0.0.0.1
 */

fun main(vararg args: String) {
    generateArray(10000).apply {
        test(DefaultSort(copyOf()))
        test(SelectionSort(copyOf()))
        test(InsertionSort(copyOf()))
        test(ShellSort(copyOf()))
        test(QuickSort(copyOf()))
        test(Quick3WaySort(copyOf()))
    }

    merge(generateArray(10).apply {
        DefaultSort(this).apply {
            sortWithCounter()
            print()
        }
    }, generateArray(10).apply {
        DefaultSort(this).apply {
            sortWithCounter()
            print()
        }
    }).apply {
        DefaultSort(this).apply {
            println(if (isSorted()) "succeed" else "fail")
            print()
            println("complete")
        }
    }
}

class Quick3WaySort<T : Comparable<T>>(array: Array<T>) : QuickSort<T>(array) {

    override fun sortInside(left: Int, right: Int) {
        if (right <= left) return

        var lt = left
        var i = left + 1
        var gt = right

        val v = array[left]

        while (i <= gt) {
            when {
                array[i] < v -> exchange(lt++, i++)
                array[i] > v -> exchange(i, gt--)
                else -> i++
            }
        }

        sortInside(left, lt - 1)
        sortInside(gt + 1, right)
    }
}

open class QuickSort<T : Comparable<T>>(array: Array<T>) : Sort<T>(array) {

    override fun sort() {
        sortInside(0, array.size - 1)
    }

    protected open fun sortInside(left: Int, right: Int) {
        if (right <= left) return

        val partition = partition(left, right)
        sortInside(left, partition - 1)
        sortInside(partition + 1, right)
    }

    private fun partition(left: Int, right: Int): Int {
        var i = left
        var j = right + 1

        val v = array[left]

        while (true) {
            while (array[++i] < v) if (i == right) break
            while (v < array[--j]) if (j == left) break
            if (i >= j) break
            exchange(i, j)
        }

        exchange(left, j)
        return j
    }
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

fun <T : Comparable<T>> merge(left: Array<T>, right: Array<T>): Array<T> {
    return when {
        left.isEmpty() -> right
        right.isEmpty() -> left
        else -> merge(left + right, left.size - 1)
    }
}

fun <T : Comparable<T>> merge(array: Array<T>, split: Int): Array<T> {
    val copy = array.copyOf()

    var i = 0
    var j = split + 1

    (0 until array.size).forEach {
        when {
            i > split -> array[it] = copy[j++]
            j > array.size - 1 -> array[it] = copy[i++]
            copy[j] < copy[i] -> array[it] = copy[j++]
            else -> array[it] = copy[i++]
        }
    }

    return array
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