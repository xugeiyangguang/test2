package ExperienceOfferTest2;

public class A10_二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(0xFFFFFFFF));
    }
    public static int NumberOf1(int n) {
        int count = 0;
        while (n!=0) {
            count++;
            //一个数和该数-1做与，会将原来整数最右边的1变为0
            n = n & (n - 1);
        }
        return count;
    }
}
