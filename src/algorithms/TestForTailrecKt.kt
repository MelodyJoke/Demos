package algorithms

import java.math.BigInteger

/**
 * description TODO
 * author Melo Chan
 * date 2017/5/23
 * version 0.0.0.1
 */
fun main(args: Array<String>) {
    println(factorial(100000, BigInteger.ONE))
}

tailrec fun factorial(from: Int, last: BigInteger): BigInteger {
    return if (from == 0) last else factorial(from - 1, last.multiply(BigInteger.valueOf(from.toLong())))
}