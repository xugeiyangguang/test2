package 重要算法;

public class 递归查询 {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Fun(a, 6, 0, a.length - 1));
        System.out.println(Func1(a, 55));
    }


    //递归
    public static int Fun(int[] a, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (a[mid] == target) {
            return mid;
        } else if (a[mid] < target) {
            return Fun(a, target, mid + 1, end);
        } else {
            return Fun(a, target, 0, mid - 1);
        }
    }

    //循环：常用
    public static int Func1(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (a[mid] < target) {
                start = mid + 1;
            } else if (a[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
            mid = (start + end) / 2;

        }
        return -1;

    }
}
