package 测试;

public class 出现次数超过数组长度的一半 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int re = MoreThanHalfNum_Solution(a);
        System.out.println();
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int start = 0;
        int end = array.length-1;
        int k = Partiton(array,start,end);
        while(k!=array.length/2){
            if(k<array.length/2){
                start = k+1;
            }else{
                end = k-1;
            }
            k = Partiton(array,start,end);
        }
        int num = array[k];
        int re = 0;
        for(int i:array){
            if(i==num){
                re++;
            }
        }
        if(re>array.length/2){
            return num;
        }
        return -1;
    }
    public static int Partiton(int[] a,int start,int end){
        if(start>end||start>a.length-1||end<0){
            return -1;
        }
        int key = a[start];

        while(start<end){
            while(start<end&&a[end]>=key){
                end--;
            }
            a[start] = a[end];
            while(start<end&&a[start]<=key){
                start++;
            }
            a[end] = a[start];
        }
        a[start] = key;
        return start;
    }
}
