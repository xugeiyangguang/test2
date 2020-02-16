package Leetcode;

import java.util.ArrayList;

public class Divide {
    public static void main(String[] args) {
        Divide test = new Divide();
        System.out.println(test.divide(64,3));
    }
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            if (dividend > 0) {
                return Integer.MAX_VALUE;
            } else return Integer.MIN_VALUE;
        }
        int dividend1 = Math.abs(dividend);
        int divisor1 = Math.abs(divisor);
        int re = 0;
        while (dividend1 >= divisor1) {
            int count = 1;
            int sum = divisor1;
            while (sum + sum <= dividend1) {
                sum += sum;
                count += count;
            }
            dividend1 -= sum;
            re += count;
        }
        return (dividend >> 31 ^ divisor >> 31) == 1 ? -re : re;
    }
}
