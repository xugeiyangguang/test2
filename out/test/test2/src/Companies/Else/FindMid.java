package Companies.Else;

public class FindMid {
    public static void main(String[] args) {
        int[] a = {1,2,5,3,4};

        int start = 0;
        int end = a.length-1;
        int index = partition(a,start,end);
        int k = a.length/2;
        while (index!=k){
            if (index < k) {
                start = index + 1;
            } else {
                end = index-1;
            }
            index = partition(a,start,end);
        }
        System.out.println(a[index]);
    }
    public static int partition(int[] a,int start,int end){
        int key = a[start];
        int i  = start;
        int j = end;
        while (i<j){
            while (i<j&&a[j]>=key){
                j--;
            }
            a[i] = a[j];
            while (i<j&&a[i]<=key){
                i++;
            }
            a[j] = a[i];
        }
        a[j] = key;
        return i;
    }
}
