package Leetcode;

public class A22maxProfit {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int re = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                re += prices[i + 1] - prices[i];
            }
        }
        return re;
    }
}
