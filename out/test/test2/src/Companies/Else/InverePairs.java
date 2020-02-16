package Companies.Else;

public class InverePairs {
    static int count = 0;
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 0};
        int re = InversePairs(a);
        System.out.println(re);

    }
    public static int InversePairs(int [] array) {
        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++){
            copy[i] = array[i];

        }
        fun(array,copy,0,array.length-1);
        return count%1000000007;

    }
    public static void fun(int[] array,int[] copy,int start,int end){
        if(start==end){
            return;
        }
        int mid = (start+end)>>1;
        fun(copy,array,start,mid);
        fun(copy,array,mid+1,end);

        int length = end-mid;
        int a = mid;
        int b= end;
        int lastindex= end;
        while(a>=start&&b>=mid+1){
            if(array[a]>array[b]){
                count=count+length;
                count = count%1000000007;
                copy[lastindex--] = array[a--];

            }else{
                copy[lastindex--] = array[b--];
                length--;
            }
        }
        while(a>=start){
            copy[lastindex--] = array[a--];
        }
        while(b>=mid+1){
            copy[lastindex--] = array[b--];
        }

    }
}
