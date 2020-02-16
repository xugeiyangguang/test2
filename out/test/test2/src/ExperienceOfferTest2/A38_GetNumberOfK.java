package ExperienceOfferTest2;

public class A38_GetNumberOfK {
    public static void main(String[] args) {
        A38_GetNumberOfK test = new A38_GetNumberOfK();
        int[] arr = {3, 3, 3, 3, 4, 5};
        int re = test.GetNumberOfK(arr, 3);
        System.out.println();
    }
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0 || k < array[0] || k > array[array.length - 1]) {
            return 0;
        }
        int left = GetNumberOfKFirst(array, k, 0, array.length - 1);
        int right = GetNumberOfKLast(array, k, 0, array.length - 1);
        if (left == -1 && right == -1) {
            return 0;
        }
        return GetNumberOfKLast(array, k, 0, array.length - 1) - GetNumberOfKFirst(array, k, 0, array.length - 1) + 1;
    }

    public int GetNumberOfKFirst(int[] array, int k, int start, int last) {
        if (start == last) {
            return array[start] == k ? start : -1;
        }
        int mid = (start + last) >> 1;
        if (mid == 0 || array[mid] == k && array[mid - 1] != k) {
            return mid;
        }
        if (array[mid] >= k) {
            last = mid - 1;
        }
        if (array[mid] < k) {
            start = mid + 1;
        }
        return GetNumberOfKFirst(array, k, start, last);
    }
    public int GetNumberOfKLast(int[] array, int k, int start, int last) {
        if (start == last) {
            return array[start] == k ? start : -1;
        }
        int mid = (start + last) >> 1;
        if (mid == array.length - 1 || array[mid] == k && array[mid + 1] != k) {
            return mid;
        }
        if (array[mid] > k) {
            last = mid - 1;
        }
        if (array[mid] <= k) {
            start = mid + 1;
        }
        return GetNumberOfKLast(array, k, start, last);
    }
}
