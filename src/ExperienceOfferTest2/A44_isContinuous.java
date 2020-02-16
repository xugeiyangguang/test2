package ExperienceOfferTest2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A44_isContinuous {
    public static void main(String[] args) {
        int[] numbers = {0, 0, 3, 0, 0};
        A44_isContinuous test = new A44_isContinuous();
        boolean re = test.isContinuous(numbers);
        System.out.println();
    }
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i:numbers
             ) {
            list.add(i);
        }

        Collections.sort(list);
        int zeroCount = 0;
        for (int i:numbers
             ) {
            if (i == 0) {
                zeroCount++;
            }

        }
        int gap = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (list.get(i) != 0) {
                if (list.get(i) == list.get(i + 1)) {
                    return false;
                }
                gap += list.get(i + 1) - list.get(i) - 1;
            }

        }
        if (zeroCount >= gap) {

            return true;
        }
        return false;
    }
}
