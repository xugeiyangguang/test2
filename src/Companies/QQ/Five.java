package Companies.QQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Five {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] company = new int[n];
        for (int i = 0; i < n; i++) {
            company[i] = s.nextInt();
        }
        int[] gym = new int[n];
        for (int i = 0; i < n; i++) {
            gym[i] = s.nextInt();
        }

        ArrayList<Integer> re = new ArrayList<>();
        func(company, gym, 0, -1, 0, re);
        Collections.sort(re);
        System.out.println(re.get(0));

    }

    /*-1:上一次没有任务
       0：上一天上班
       1：锻炼
       2：休息
    * */
    public static void func(int[] company,int[] gym, int start, int last, int count, ArrayList<Integer> re) {
        if (start == company.length) {
            re.add(count);
            return;
        }
        if (last == -1 || last == 2) {
            if (company[start] == 0 && gym[start] == 0) {
                func(company, gym, start + 1, 2, count + 1, re);
            }
            if (company[start] == 1) {
                func(company, gym, start + 1, 0, count, re);
            }
            if (gym[start] == 1) {
                func(company, gym, start + 1, 1, count, re);
            }

        } else if (last == 0) {
            if (gym[start] == 0) {
                func(company, gym, start + 1, 2, count + 1, re);
            }else{
                if (gym[start] == 1) {
                    func(company, gym, start + 1, 1, count, re);
                }
            }

        } else if (last == 1) {
            if (company[start] == 0) {
                func(company, gym, start + 1, 2, count + 1, re);
            }else{
                if (company[start] == 1) {
                    func(company, gym, start + 1, 0, count, re);
                }
            }

        }
    }
}
