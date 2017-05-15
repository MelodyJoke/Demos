package algorithms;

import java.util.Scanner;

/**
 * description Test for algorithms
 * author Melo Chan
 * date 2016/11/23
 * version 0.0.0.1
 */
public class  Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 欧几里得最大公约数算法
        System.out.println("type in two positive integers plz:");
        try {
            int left = Integer.parseInt(scanner.next());
            int right = Integer.parseInt(scanner.next());
            System.out.println("the greatest common divisor of " + left + " and " + right + " is " + euclidAlg(left, right) + ".");
        } catch (Exception e) {
            System.out.println("something wrong:" + e.getMessage());
        }

        scanner.close();
    }

    /**
     * 欧几里得算法
     * 两个非负整数的最大公约数问题
     * 1.若其中一个数为0， 则另一个数为问题的解
     * 2.较大数除以较小数的余数， 与较小数的最大公约数为问题的解
     */
    private static int euclidAlg(int left, int right) {
        if (left >= right) {
            int temp = left;
            left = right;
            right = temp;
        }

        if (left == 0) return right;

        return euclidAlg(right % left, left);
    }
}
