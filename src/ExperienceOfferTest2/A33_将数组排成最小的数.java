package ExperienceOfferTest2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class A33_将数组排成最小的数 {
    public static void main(String[] args) {
        int[] array = {32,231};
        A33_将数组排成最小的数 test = new A33_将数组排成最小的数();
        String re = test.PrintMinNumber(array);
        System.out.println();
    }
    public static String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i:numbers
        ) {
            list.add(String.valueOf(i));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuffer re = new StringBuffer();
        for (String i:list
        ) {
            re.append(i);
        }
        return re.toString();
    }
}
