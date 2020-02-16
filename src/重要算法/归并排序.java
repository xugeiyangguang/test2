package 重要算法;

public class 归并排序 {
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 3, 1};
        int[] copy = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            copy[i] = a[i];
        }
        func(a, copy, 0, a.length - 1);
        for (int i:copy
             ) {
            System.out.print(i);
        }

    }

    public static void func(int[] a, int copy[], int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        func(copy, a, start, mid);
        func(copy,a,mid+1,end);
        int last = end;
        int olast = mid;
        int tlast = end;
        while (olast >= start && tlast > mid) {
            if (a[olast] > a[tlast]) {
                copy[last--] = a[olast];
                olast--;
            } else {
                copy[last--] = a[tlast];
                tlast--;
            }
        }
        while (olast >= start) {
            copy[last--] = a[olast];
            olast--;
        }
        while (tlast > mid) {
            copy[last--] = a[tlast];
            tlast--;
        }
    }
}
