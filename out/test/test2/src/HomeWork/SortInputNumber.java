package HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortInputNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        String[] numbers = str.split(",");
        int[] num = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            num[i] = Integer.valueOf(numbers[i]);
        }
        Arrays.sort(num);
        for (int i:num
             ) {
            System.out.print(i+" ");
        }

    }
}
