package Companies.Else;

import ExperienceOfferTest.InversePairs36;

import java.util.Scanner;

public class PeopleHight {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int re = 0;
        /*for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    re++;11
                }
            }
        }*/
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = arr[i];
        }
        int i = InverseCore(arr, copy, 0, n - 1);
        System.out.println(i);
    }

    public static int InverseCore(int[] arr, int[] copy, int start, int end) {
        if (start == end) {
            return 0;
        }
        int length = (end + start) / 2;
        int left = InverseCore(copy, arr, start, length);
        int right = InverseCore(copy, arr, length + 1, end);
        int i = length;
        int j = end;
        int count = 0;
        int copyIndex = end;
        while (i >= start && j >= length + 1) {
            if (arr[i] > arr[j]) {
                count += j - length;
                copy[copyIndex--] = arr[i--];
            } else {
                copy[copyIndex--] = arr[j--];
            }
        }
        if (i >= start) {
            copy[copyIndex--] = arr[i--];
        }
        if (j >= length + 1) {
            copy[copyIndex--] = arr[j--];
        }
        return left + right + count;
    }
}
