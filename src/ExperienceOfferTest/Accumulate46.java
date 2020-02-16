package ExperienceOfferTest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Accumulate46 {
    public static void main(String[] args) {
        Accumulate46 test = new Accumulate46();
        System.out.println(test.Sum_Solution(3));
    }
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
