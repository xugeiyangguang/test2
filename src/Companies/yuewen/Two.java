package Companies.yuewen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        ArrayList<Integer> c = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            c.add(i);
        }
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        int p = s.nextInt();
        int q = s.nextInt();
        int aa = c.indexOf(p);
        c.remove(aa);
        int bb = c.indexOf(q);
        c.remove(bb);

        a.add(p);
        b.add(q);
        for (int i = 1; i < m; i++) {
            p = s.nextInt();
            q = s.nextInt();
            aa = c.indexOf(p);
            if (aa >= 0) {
                c.remove(aa);
            }
            bb = c.indexOf(q);
            if (bb > 0) {
                c.remove(bb);
            }
            if (!a.contains(p)) {
                a.add(p);
            } else {
                b.add(p);
            }
            if (!a.contains(q)) {
                a.add(q);
            } else {
                b.add(q);
            }
        }
        if (c.size() != 0) {
            if (a.size() > b.size()) {
                while (c.size() != 0) {
                    int tmp = c.get(0);
                    a.add(tmp);
                    c.remove(0);
                }
                System.out.println(a.size());

            } else {
                while (c.size() != 0) {
                    int tmp = c.get(0);
                    b.add(tmp);
                    c.remove(0);
                }
                System.out.println(b.size());

            }
            return;
        } else {
            System.out.println(Math.max(a.size(), b.size()));
        }


    }
}
