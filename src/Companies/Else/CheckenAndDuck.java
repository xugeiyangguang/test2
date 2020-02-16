package Companies.Else;

import java.util.Scanner;

public class CheckenAndDuck {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        char[] arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i);
        }
        int count = 0;
        int re = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 'C') {
                re++;
            } else {
                count += re;
            }
        }


        System.out.println(count);
    }
}
