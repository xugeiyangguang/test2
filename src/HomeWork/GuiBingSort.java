package HomeWork;

public class GuiBingSort {
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        int[] copy = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            copy[i] = a[i];
        }
        func(a, copy, 0, a.length - 1);
        System.out.println();
    }
    public static void func(int[] a,int copy[],int start,int end) {
        if (start == end){
            return;
        }
        int mid = (start + end) / 2;
        func(copy, a, start, mid);
        func(copy, a, mid + 1, end);
        int copy_end = end;
        int one_end = mid;
        int two_end = end;
        while (one_end >= start && two_end >= mid + 1) {
            if (a[one_end] > a[two_end]) {
                copy[copy_end--] = a[one_end--];
            } else {
                copy[copy_end--] = a[two_end--];
            }
        }
        while (one_end >= start) {
            copy[copy_end--] = a[one_end--];
        }
        while (two_end >= mid + 1) {
            copy[copy_end--] = a[two_end--];
        }
    }
}
