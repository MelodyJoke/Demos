package algorithms

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

/**
 * description TODO
 * author Melo Chan
 * date 2017/11/10
 * version 0.0.0.1
 */

fun main(args: Array<String>) {
    println(Arrays.toString(getResultWithInterest(50.0, 0.049, 20.0)))
    println(Arrays.toString(getResultWithoutInterest(50.0, 0.049, 20.0)))

    for (i in 1..240) {
        print("第${i}个月 ")
        println(Arrays.toString(getDetailWithInterest(50.0, 0.049, 20.0, i.toDouble())))
    }

    for (i in 1..240) {
        print("第${i}个月 ")
        println(Arrays.toString(getDetailWithoutInterest(50.0, 0.049, 20.0, i.toDouble())))
    }
}

fun getResultWithInterest(amount: Double, rate: Double, limit: Double): Array<String> {
    val realAmount = amount * 10000
    val realRate = rate / 12
    val realLimit = limit * 12

    val average = (realAmount * realRate * Math.pow(1 + realRate, realLimit)) / (Math.pow(1 + realRate, realLimit) - 1)
    val total = realAmount * realLimit * realRate * Math.pow(1 + realRate, realLimit) / (Math.pow(1 + realRate, realLimit) - 1)
    val interest = total - realAmount

    return arrayOf(fixFloat(average), fixFloat(interest), fixFloat(total))
}

fun getResultWithoutInterest(amount: Double, rate: Double, limit: Double): Array<String> {
    val realAmount = amount * 10000
    val realRate = rate / 12
    val realLimit = limit * 12

    val first = realAmount / realLimit + realAmount * realRate
    val step = (realAmount / realLimit) * realRate
    val interest = (realLimit + 1) * realAmount * realRate / 2
    val total = interest + realAmount

    return arrayOf(fixFloat(first), fixFloat(step), fixFloat(interest), fixFloat(total))
}

fun getDetailWithInterest(amount: Double, rate: Double, limit: Double, month: Double): Array<String> {
    val realAmount = amount * 10000
    val realRate = rate / 12
    val realLimit = limit * 12

    val average = (realAmount * realRate * Math.pow(1 + realRate, realLimit)) / (Math.pow(1 + realRate, realLimit) - 1)
    val total = realAmount * realLimit * realRate * Math.pow(1 + realRate, realLimit) / (Math.pow(1 + realRate, realLimit) - 1)

    val capital = realAmount * realRate * Math.pow(1 + realRate, month - 1) / (Math.pow(1 + realRate, realLimit) - 1)
    val interestMonthly = average - capital
    val rest = total - average * month

    return arrayOf(fixFloat(average), fixFloat(capital), fixFloat(interestMonthly), fixFloat(rest))
}

fun getDetailWithoutInterest(amount: Double, rate: Double, limit: Double, month: Double): Array<String> {
    val realAmount = amount * 10000
    val realRate = rate / 12
    val realLimit = limit * 12

    val first = realAmount / realLimit + realAmount * realRate
    val step = (realAmount / realLimit) * realRate
    val interest = (realLimit + 1) * realAmount * realRate / 2
    val total = interest + realAmount

    val capital = realAmount / realLimit
    val interestMonthly = first - step * (month - 1) - capital
    val rest = total - (month - 0) * first + (month - 1) * (month - 0) / 2 * step

    return arrayOf(fixFloat(capital), fixFloat(interestMonthly), fixFloat(rest))
}

fun fixFloat(src: Double): String = fixFloat(BigDecimal.valueOf(src), 2)

fun fixFloat(src: BigDecimal, len: Int): String {
    var length = len
    if (length < 1) length = 1

    val builder = StringBuilder()
    for (i in 0 until length) builder.append("0")

    val lengthStr = builder.toString()

    val format = DecimalFormat("#." + lengthStr)
    val result = format.format(src)

    if ("." + lengthStr == result) return "0"

    if (result.endsWith("." + lengthStr)) return result.replace(("\\." + lengthStr).toRegex(), "")

    return result
}