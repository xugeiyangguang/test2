package Companies.Liulishuo;

import java.util.Scanner;



class Two {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = s.nextInt();
            }
        }
        int re = func(array);
        System.out.println(re);
    }
    public static int func(int[][] array) {
        int[] AA = new int[]{0, 1, 0, -1};
        int[] BB = new int[]{1, 0, -1, 0};

        int N = array.length;
        int M = array[0].length;
        int re = 0;

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < M; ++j)
                if (array[i][j] > 0) {
                    re += 2;
                    for (int k = 0; k < 4; ++k) {
                        int p = i + AA[k];
                        int q = j + BB[k];
                        int nv = 0;
                        if (0 <= p && p < N && 0 <= q && q < M)
                            nv = array[p][q];

                        re += Math.max(array[i][j] - nv, 0);
                    }
                }

        return re;
    }
}
