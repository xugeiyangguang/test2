package ExperienceOfferTest2;

import java.util.ArrayList;

public class A41_FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 2, 6};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        A41_FindNumsAppearOnce test = new A41_FindNumsAppearOnce();
        test.FindNumsAppearOnce(array, num1, num2);
        System.out.println();
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int total = 0;
        for (int i:array
             ) {
            total = total ^ i;
        }
        int index = 1;
        //找到从右边开始第一个为零的位置
        while ((index & total) == 0) {
            index <<= 1;
        }
        for (int i:array
             ) {
            if ((i & index) == 0) {
                num1[0] = num1[0] ^ i;
            } else {
                num2[0] = num2[0] ^ i;
            }
        }
        return;
    }
}
