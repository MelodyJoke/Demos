package kotlin_demo

/**
 * description For grammar exercise
 * author Melo Chan
 * date 2017/8/15
 * version 0.0.0.1
 */

fun main(args: Array<String>) {
    println("Hello Venus")

    val greeter = Greeter("Ace of Angels")
    greeter.greet()
    greeter.greets("Bestie", "Exid", "Fiestar")

    println("the greeter's greet is '${greeter.greet}'.")

    println(checkString(null))
    println(checkString("Girl's Day"))

    println(arrayOf(1, 2, 3)[0])
    println(Array(3, { i -> i * 2 })[2])

    println(3 in 1..10 step 2)

    (1..10 step 2).forEach({
        when (it) {
            1 -> println("low")
            2, 3 -> println("middle")
            in 4..6 -> println("high")
            else -> println("too high")
        }
    })

    println((1..100).sum())

    for ((index, value) in (1..10 step 2).withIndex()) {
        println("index: $index, value: $value")
    }

    val whisper = Whisper("Kara")
    println(whisper.whisper())
    println(whisper is Whisper)
    println(whisper is Greeter)
    whisper.perform { it.plus(it).plus(it) }
    whisper.perform { it.replace('a', 'e') }
}

fun checkString(src: String?): String {
    return src ?: ""
}

open class Greeter(val greet: String) {
    fun greet() {
        println(greet)
    }

    fun greets(vararg greets: String) {
        greets.forEach { println(it) }
    }
}

class Whisper(whisper: String) : Greeter(whisper) {
    fun whisper(): String {
        greet()
        return greet
    }

    inline fun perform(init: (String) -> String) {
        println(init(greet))
    }
}

