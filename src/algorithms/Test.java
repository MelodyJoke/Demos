package algorithms;

import java.util.Scanner;

/**
 * description Test for algorithms
 * author Melo Chan
 * date 2016/11/23
 * version 0.0.0.1
 */
public class Test {

    public static void main(String[] args) {
        /*SimpleDateFormat format = new SimpleDateFormat("yyMMddhhmmss", Locale.CHINA);

        long timeMillis = System.currentTimeMillis();
        Random random = new Random();
        String order = "P" + format.format(new Date(timeMillis)) + (timeMillis / 1000 % 10000) + (random.nextInt(90) + 10);

        System.out.println(order);*/
        /*Scanner scanner = new Scanner(System.in);

        // 欧几里得最大公约数算法
        System.out.println("type in two positive integers plz:");
        try {
            int left = Integer.parseInt(scanner.next());
            int right = Integer.parseInt(scanner.next());
            System.out.println("the greatest common divisor of " + left + " and " + right + " is " + euclidAlg(left, right) + ".");
        } catch (Exception e) {
            System.out.println("something wrong:" + e.getMessage());
        }

        scanner.close();*/

        /*Random random = new Random();
        System.out.println(random.nextInt(900000) + 100000);*/

        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hars", "root", "melody");
            PreparedStatement statement = (PreparedStatement) connection.prepareStatement("insert into user(name, nick, password, info) values (?, 'melo', 'pass', 'none');", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(Math.random()));
            statement.executeUpdate();
            ResultSet set = statement.getGeneratedKeys();
            if (set.next()) System.out.println(set.getInt(1));
            set.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*System.out.println(1 ^ 1506756862949L);
        System.out.println(1 ^ 1506756862948L);*/

        System.out.println(new Calculator().calc(new Scanner(System.in).nextLine()));
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
