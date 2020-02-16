package 测试;

public class 数字在排序数组中出现的次数 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 3, 4, 5};
        int re = GetNumberOfK(a, 3);
        System.out.println();
    }

    public static int GetNumberOfK(int [] array , int k) {
        if(array==null||array.length==0){
            return -1;
        }
        int start = getStart(array,0,array.length-1,k);
        int end = getEnd(array,0,array.length-1,k);
        if(start==-1){
            return -1;
        }
        return end-start+1;
    }
    public static int getStart(int[] a,int start,int end,int k){
        if(start>end){
            return -1;
        }
        int mid;
        while(start<=end){
            mid = (start+end)/2;
            if(a[mid]>k){
                end = mid-1;
            }else if(a[mid]<k){
                start = mid+1;
            }else{
                if(mid==0||a[mid-1]!=k){
                    return mid;
                }else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    public static int getEnd(int[] a,int start,int end,int k){
        if(start>end){
            return -1;
        }
        int mid;
        while(start<=end){
            mid = (start+end)/2;
            if(a[mid]>k){
                end = mid-1;
            }else if(a[mid]<k){
                start = mid+1;
            }else{
                if(mid==end||a[mid+1]!=k){
                    return mid;
                }else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}
