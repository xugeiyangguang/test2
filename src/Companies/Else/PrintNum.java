package Companies.Else;

public class PrintNum {
    public static void main(String[] args) {
        int target = 2;
        int[] a = new int[2];
        PrintNum test = new PrintNum();
        test.fun(a,0);
    }

    public void fun(int[] a, int n) {
        if (n == a.length   ) {
            print(a);
            return;
        }
        for (int i = 0; i < 10; i++) {
            a[n] = i;
            fun(a, n + 1);
        }
        return;
    }
    public void print(int[] a) {
        int i = 0;
        for (; i < a.length; i++) {
            if (a[i] != 0) {
                break;
            }
        }
        for (; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
