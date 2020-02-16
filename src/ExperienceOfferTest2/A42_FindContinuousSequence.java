package ExperienceOfferTest2;

import java.util.ArrayList;

public class A42_FindContinuousSequence {
    public static void main(String[] args) {
        A42_FindContinuousSequence test = new A42_FindContinuousSequence();
        ArrayList<ArrayList<Integer>> re = test.FindContinuousSequence(0);
        System.out.println();
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum <= 0) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        int start = 1;
        int end = 1;
        int total = 1;
        while (end < sum) {
            if (total != sum) {
                if (total < sum) {
                    end++;
                } else {
                    start++;
                }
            } else {
                ArrayList list = new ArrayList();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                re.add(list);
                start++;
            }
            total = (end - start + 1) * (start + end) / 2;
        }
        return re;
    }
}
