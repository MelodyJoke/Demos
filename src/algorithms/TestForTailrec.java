package algorithms;

import java.math.BigInteger;

/**
 * description TODO
 * author Melo Chan
 * date 2017/5/23
 * version 0.0.0.1
 */
public class TestForTailrec {

    public static void main(String... args) {
        System.out.println(factorial(100000, BigInteger.ONE));
    }

    private static BigInteger factorial(int from, BigInteger last) {
        return from == 0 ? last : factorial(from - 1, last.multiply(BigInteger.valueOf(from)));
    }
}
