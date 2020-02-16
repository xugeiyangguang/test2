package 面试常见;

public class 不在数组中的第一个最小正整数 {
    public static void main(String[] args) {
        int[] A = {};
        int re = firstMissingPositive(A);
        System.out.println(re);
    }

    public static int firstMissingPositive(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        int[] a = new int[A.length];
        for(int i=0;i<A.length;i++){
            if(A[i]<=0||A[i]>A.length){
                continue;
            }
            a[A[i]-1] = 1;
        }
        for(int i=0;i<a.length;i++){
            if(a[i]==0){
                return i+1;
            }
        }
        return a.length;
    }
}
