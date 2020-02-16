package Companies.bilibili;

import java.util.Scanner;

public class 背包问题 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int bag = s.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = s.nextInt();
        }
        int[][] dp = new int[n + 1][bag + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= bag; j++) {
                int tmp;
                if (j >= weight[i - 1]) {
                    tmp = value[i - 1];
                    if (j - weight[i - 1] >= 0) {
                        tmp += dp[i - 1][j - weight[i - 1]];
                    }
                } else {
                    tmp = 0;
                }

                dp[i][j] = Math.max(dp[i - 1][j], tmp);
            }
        }
        System.out.println(dp[n][bag]);
    }
}
