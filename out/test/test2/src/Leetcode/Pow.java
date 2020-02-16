package Leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pow {
    public static void main(String[] args) {
        Pow test = new Pow();
        System.out.println(test.pow(2, -2147483648));
    }
    public double pow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / x * 1 / pow(x, -(n + 1));
        }
        if (n % 2 != 0) {
            return x * pow(x, n - 1);
        }

        double re = pow(x, n / 2);
        re *= re;
        return re;
    }
}
