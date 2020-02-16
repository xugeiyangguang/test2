package Companies.Else;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class River {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String people = scanner.nextLine();
        String[] s = people.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            list.add(Integer.valueOf(s[i]));
        }
        int limit = scanner.nextInt();
        Collections.sort(list);
        int count = 0;
        while (list.size() != 0 ) {
            int right = list.size() - 1;
            while (right > 0 && list.get(0) + list.get(right) > limit) {
                right--;
            }
            if (right == 0) {
                break;
            }
            list.remove(right);
            list.remove(0);
            count++;
        }
        if (list.size() != 0) {
            count += list.size();
        }
        System.out.println(count);
    }
}
