package ExperienceOfferTest;

import java.lang.management.BufferPoolMXBean;

public class UglyNumber34 {
    public static void main(String[] args){
        UglyNumber34 test = new UglyNumber34();
        System.out.println(test.GetUglyNumber_Solution(8));
    }
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0){
            return 0;
        }
        int[] UglyNumberArray = new int[index];
        UglyNumberArray[0] = 1;
        int nextIndex = 1;
        int Multiply2 = 0;
        int Multiply3 = 0;
        int Multiply5 = 0;

        while (nextIndex < index){
            UglyNumberArray[nextIndex] = Math.min(Math.min(UglyNumberArray[Multiply2]*2,UglyNumberArray[Multiply3]*3),UglyNumberArray[Multiply5]*5);
            while (UglyNumberArray[Multiply2]*2 <= UglyNumberArray[nextIndex]){ Multiply2++; }
            while (UglyNumberArray[Multiply3]*3 <= UglyNumberArray[nextIndex]){ Multiply3++; }
            while (UglyNumberArray[Multiply5]*5 <= UglyNumberArray[nextIndex]){ Multiply5++; }
            nextIndex++;
        }

        return UglyNumberArray[nextIndex-1];
    }
}
