package Companies.Else;

public class TreeColor {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 2, 3, 1, 2, 3};
        int p1 = a.length - 1;
        int p2 = 0;
        int p3 = 0;
        while (p2 < p1) {
            if (a[p2] == 1) {
                change(a, p2, p1);
                p1--;
            } else if (a[p2] == 3) {
                change(a, p2, p3);
                p3++;
                if (p2 < p3) {
                    p2 = p3 + 1;
                }
            } else {
                p2++;
            }
        }
        for (int i: a
             ) {
            System.out.print(i);
        }
    }

    public static void change(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
