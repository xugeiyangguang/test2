package 面试常见;

public class 最大乘积 {
    public static void main(String[] args) {
        int[] a = {1, 2, -1, 2, -100};
        System.out.println(func1(a));
    }
    public static int func(int[] a){
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(cur<0){
                cur = a[i];
            }else{
                cur +=a[i];
            }
            max = Math.max(cur,max);
        }
        return max;
    }

    public static int func1(int[] a){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int cur = 1;
        for(int i=0;i<a.length;i++){
            if(cur==0){
                cur = a[i];
            }else{
                cur *=a[i];

            }
            max = Math.max(max,cur);
            min = Math.min(min,cur);

        }

        return max;
    }
}
