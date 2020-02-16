package Companies.Else;

public class RoatateArr {
    public static void main(String[] args){
        int[] a = {3,4,5,1,2};
        int[] b = {5,1,2,3,4};
        System.out.println(find(b,0,b.length-1));
    }
    public static int find(int[] a,int left,int end){
        int mid = (left+end)/2;
        if(a[mid]!=a[left]&&a[mid]!=a[end]){
            while(left<end){
                if(a[mid]>=a[left]){
                    left = mid+1;

                }
                if(a[mid]<=a[end]){
                    end = mid-1;
                }
                mid = (left+end)/2;
            }
            return a[left];
        }
        else{
            return find2(a);
        }
    }
    public static int find2(int[] a){
        int min = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            min = Math.min(a[i],min);
        }
        return min;
    }
}
