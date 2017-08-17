package kotlin_demo

/**
 * description First demo of kotlin
 * author Melo Chan
 * date 2017/5/22
 * version 0.0.0.1
 */

fun main(args: Array<String>) {
    { x: Int, y: Int ->
        println("${x + y}")
    }(1, 3)

    val firstName: String? = "Hello"
    val lastName: String? = "Zhang"

    println("my name is ${getName(firstName, lastName)}")

    val test = { it: String ->
        println(it)
    }
    test("hello")
}

fun hasEmpty(vararg strArray: String?): Boolean {
    for (str in strArray) {
        str ?: return true
    }
    return false
}

fun getName(firstName: String?, lastName: String? = "unknown"): String {
    if (hasEmpty(firstName, lastName)) {
        firstName?.let { return@getName "$firstName ${checkName(lastName)}" }
        lastName?.let { return@getName "${checkName(firstName)} $lastName" }
    }
    return "$firstName $lastName"
}

fun checkName(name: String?): String = name ?: "unknown"