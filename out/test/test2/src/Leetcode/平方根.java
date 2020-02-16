package Leetcode;

public class 平方根 {
    public static void main(String[] args) {
        int re = sqrt(2147395599);
        System.out.println(re);
    }
    public static int sqrt(int x) {
        if(x<=1){
            return x;
        }
        int start = 1;
        int end = x/2;
        int mid = (start+end)/2;
        while(start<=end){
            if (x / mid > mid && x / (mid + 1) < (mid + 1)) {
                return mid;
            } else if (x / mid > mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start+end)/2;
        }
        return mid;
    }
}
