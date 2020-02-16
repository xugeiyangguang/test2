package ExperienceOfferTest2;

public class Test {
    public void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int re = partition(arr, 0, arr.length - 1);
        System.out.println();
    }
    public  int partition(int[] arr,int low,int high){

        int key = arr[low];
        while(high > low){
            /*里面循环的时候也要加上 high > low，不然有序的时候会越界*/
            while(arr[high] >= key && high > low){
                high--;
            }
            arr[low] = arr[high];
            while (arr[low] <= key && high > low){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[high] = key;
        return high;
    }
    public int partition1(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int piriot = array[left];
        while (i < j) {
            while (i < j && array[j] >= piriot) {
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] <= piriot) {
                i++;
            }
            array[j] = array[i];
        }
        array[left] = piriot;
        return left;
    }
}
