package 重要算法;

public class 各种方法快排 {
    public static void main(String[] args) {
        int[] arr = {5,2,8,9,2,3,4,9};
        各种方法快排 test = new 各种方法快排();
        test.quickSort(arr, 0, arr.length - 1);
        System.out.println();
    }
    public void quickSort(int[] arr,int left,int right){
        if (left < right) {
            int k = partition3(arr,left,right);
            quickSort(arr, left, k - 1);
            quickSort(arr, k + 1, right);
        }

    }
    //方法1：左右指针法，以首元素为基准
    public int partition1(int[] arr,int left,int right) {
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            swap(arr,left,right);
            while (left < right && arr[left] <= key) {
                left++;
            }
            swap(arr,left,right);
        }
        return left;
    }

    //方法1.1：左右指针法
    public int partition1_1(int[] arr,int left,int right) {
        int index = left;
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            while (left < right && arr[left] <= key) {
                left++;
            }
            swap(arr,right,left);
        }
        swap(arr,index,left);
        return left;
    }

    //方法2：挖坑法   以首元素为基准
    public int partition2(int[] arr,int left,int right) {
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }
    //方法三:前后指针法
    public int partition3(int[] arr,int left,int right) {
        if (left < right) {
            int key = arr[right];
            int pre = left - 1;
            while (left < right) {
                while (arr[left] < key && ++pre != left) {
                    swap(arr, pre, left);
                }
                left++;
            }
            swap(arr, ++pre, right);
            return pre;
        }
        return -1;
    }

    //交换数组中两个指定下标位置的值
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
