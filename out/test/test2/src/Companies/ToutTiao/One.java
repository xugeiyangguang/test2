package Companies.ToutTiao;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        s.nextLine();
        //加密后
        String str = s.nextLine();
        StringBuffer re = new StringBuffer();
        re.append(str.charAt(0));
        /*int end = str.length() - 1;

        for (int i = 1; i < n; i++) {
            if (i < k) {
                int tmp = (str.charAt(i) - '0') ^ (str.charAt(i - 1) - '0');
                re.append(tmp);
            } else {
                int tmp = (str.charAt(end) - '0') ^ (str.charAt(end - 1) - '0');
                end--;
                re.append(tmp);
            }

        }*/
        for (int i = 1; i < n; i++) {
            int tmp = str.charAt(i) - '0';
            if (i < k) {
                tmp = (str.charAt(i) - '0') ^ (str.charAt(i - 1) - '0');

            } else {
                int start = i - k + 1;
                for (int j = start; j < i; j++) {
                    tmp = tmp ^ (re.charAt(j) - '0');
                }
            }
            re.append(tmp);
        }
        System.out.println(re.toString());
    }
}
