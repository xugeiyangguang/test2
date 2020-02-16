package ExperienceOfferTest2;

import java.util.ArrayList;

public class A34_GetUglyNumber_Solution {
    public static void main(String[] args) {
        A34_GetUglyNumber_Solution test = new A34_GetUglyNumber_Solution();
        int re = test.GetUglyNumber_Solution(1);
        System.out.println();
    }
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        ArrayList<Integer> re = new ArrayList<>();
        re.add(1);
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        while (re.size() < index) {
            re.add(Math.min(Math.min(2 * re.get(t2), 3 * re.get(t3)), 5 * re.get(t5)));
            while (2 * re.get(t2) <= re.get(re.size() - 1)) {
                t2++;
            }
            while (3 * re.get(t3) <= re.get(re.size() - 1)) {
                t3++;
            }
            while (5 * re.get(t5) <= re.get(re.size() - 1)) {
                t5++;
            }
        }
        return re.get(re.size() - 1);
    }
}
