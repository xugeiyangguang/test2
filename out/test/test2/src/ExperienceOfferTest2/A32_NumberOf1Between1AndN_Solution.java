package ExperienceOfferTest2;

public class A32_NumberOf1Between1AndN_Solution {
    public static void main(String[] args) {
        A32_NumberOf1Between1AndN_Solution test = new A32_NumberOf1Between1AndN_Solution();
        int re = test.NumberOf1Between1AndN_Solution(5);
        System.out.println();
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        int topNumber = n;//记录数据的最高位的值
        int numberCount = 1;//记录数据的位数
        while (topNumber / 10 > 0) {
            topNumber /= 10;
            numberCount++;
        }
        int lessNumber = (int) Math.pow(10, numberCount - 1);
        int count1 = (topNumber > 1 ? lessNumber : n - lessNumber + 1);
        int count2 = (numberCount - 1) * (int) Math.pow(10, numberCount - 2) * topNumber;;
        return count1 + count2 + NumberOf1Between1AndN_Solution(n - (int) Math.pow(10, numberCount - 1) * topNumber);
    }
}
