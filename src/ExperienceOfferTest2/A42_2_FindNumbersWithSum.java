package ExperienceOfferTest2;

import java.util.ArrayList;

public class A42_2_FindNumbersWithSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 15};
        A42_2_FindNumbersWithSum test = new A42_2_FindNumbersWithSum();
        ArrayList<Integer> re = test.FindNumbersWithSum(array, 15);
        System.out.println();
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        int start = 0;
        int end = array.length - 1;
        int min = 0x7fff;
        int num1 = 0;
        int num2 = 0;
        while (start != end || end > array.length - 1) {
            if (array[start] + array[end] == sum) {
                if (min > array[start] * array[end]) {
                    num1 = array[start];
                    num2 = array[end];
                    min = array[start] * array[end];
                }
                start++;
            } else if (array[start] + array[end] < sum) {
                start++;
            } else {
                end--;
            }
        }
        if (num1 != 0 && num2 != 0) {
            ArrayList<Integer> re = new ArrayList<>();
            re.add(num1);
            re.add(num2);
            return re;
        } else {
            return new ArrayList<>();
        }


    }
}
