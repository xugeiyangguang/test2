package Companies.Else;

public class Erase {
    public static void main(String[] args) {
        int re = 0;
        int[][] a = {{0, 1, 0, 1}, {0, 1, 1, 1}, {0, 0, 1, 0}, {0, 1, 0, 0}};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    func(a, i, j);
                    re++;
                }
            }
        }
        System.out.println(re);
    }
    public static void func(int[][] a,int i, int j){
        if (i >= a.length || j >= a[0].length || i < 0 || j < 0 || a[i][j] == 0) {
            return;
        }
        a[i][j] = 0;
        func(a, i + 1, j);
        func(a, i - 1, j);
        func(a, i, j + 1);
        func(a, i, j - 1);

    }
}
