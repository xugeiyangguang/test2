package ExperienceOfferTest2;

public class A09_斐波拉契 {
    public static void main(String[] args) {

    }
    public int Fibonacci(int n) {
        int[] arr = {0, 1};
        if (n <= 1) {
            return arr[n];
        }
        int first = 0;
        int second = 1;
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = first + second;
            first = second;
            second = temp;
        }
        return temp;
    }
}
