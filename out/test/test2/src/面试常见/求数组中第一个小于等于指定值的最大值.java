package 面试常见;

public class 求数组中第一个小于等于指定值的最大值 {
    public static void main(String[] args) {
        int[] a = {2,4,6,8,10};

        func1(a, 0, a.length - 1, 4);
    }

    public static void func(int[] a, int start, int end, int target) {
        while (start <= end) {
            int mid = (start+end) / 2;
            if (a[mid] < target) {
                start = mid + 1;
            } else if (a[mid] > target) {
                end = mid - 1;
            } else {
                System.out.println(a[mid]);
                return;
            }
        }
        if (end < 0) {
            System.out.println(-1);
        } else {
            System.out.println(a[end]);
        }

    }

    //二分查找
    public static void func1(int[] a, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] < target) {
                start = mid + 1;
            } else if (a[mid] > target) {
                end = mid - 1;
            } else {
                System.out.println(a[mid]);
                return;
            }
        }
        System.out.println(-1);
    }
}
