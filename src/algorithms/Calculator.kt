package algorithms

import java.util.regex.Pattern
import javax.script.ScriptEngineManager

/**
 * description Calculator
 * author Melo Chan
 * date 2017/10/24
 * version 0.0.0.1
 */
class Calculator {

    private val engine = ScriptEngineManager().getEngineByName("javascript")

    fun calc(source: String): String {
        return try {
            engine.eval(fix(source)).toString()
        } catch (e: Exception) {
            e.printStackTrace()
            "不合法的运算式"
        }
    }

    private fun fix(source: String): String = source
}