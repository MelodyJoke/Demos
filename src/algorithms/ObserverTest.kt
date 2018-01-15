package algorithms

import java.util.*

/**
 * description TODO
 * author Melo Chan
 * date 2017/8/21
 * version 0.0.0.1
 */

class Child : Observable() {

    var growth: Int = 0
        set(value) {
            field = value
            setChanged()
            notifyObservers()
        }
}

class Parent : Observer {

    override fun update(o: Observable?, arg: Any?) {
        o?.let {
            if (it is Child) {
                println(it.growth)
            }
        }
    }
}

fun main(vararg args: String) {
    val mother = Parent()
    val father = Parent()

    val baby = Child()

    baby.addObserver(mother)
    baby.addObserver(father)
    while (baby.growth < 5) baby.growth++
}