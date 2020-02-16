package Companies.QQ;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        n = (int)Math.pow(2, n);
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = s.nextInt();
        }
        int m = s.nextInt();
        int[] gap = new int[m];
        for (int i = 0; i < m; i++) {
            gap[i] = s.nextInt();
            gap[i] = (int) Math.pow(2, gap[i]);
        }
        int[] tmp = new int[n];
        for (int i = 0; i < m; i++) {
            Reverse(seq, gap[i]);
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = seq[j];
            }
            int re = InversePairs(seq);
            for (int j = 0; j < tmp.length; j++) {
                seq[j] = tmp[j];
            }
            System.out.println(re);
        }


    }



    public static void Reverse(int[] a, int k) {
        if (k == 1) {
            return;
        }
        for (int i = 0; i < a.length; i = i + k) {
            ReverseCore(a, i, i + k - 1);

        }
    }
    public static void ReverseCore(int[] a,int start,int end){
        while (start < end) {
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            start++;
            end--;
        }
    }

    public static int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        int j = 0;
        for (int i:array
        ) {
            copy[j++] = i;
        }
        return InversePairsCore(array, copy, 0, array.length - 1);

    }

    public static int InversePairsCore(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }
        int mid = (start + end) / 2;
        int left = InversePairsCore(copy, array, start, mid);
        int right = InversePairsCore(copy, array, mid + 1, end);
        int i = mid;
        int j =end;
        int copyindex = end;
        int count = 0;
        while (i >= start && j >= mid + 1) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[copyindex--] = array[i--];
                count = count%1000000007;
            } else {
                copy[copyindex--] = array[j--];
            }
        }
        while (i >= start) {
            copy[copyindex--] = array[i--];
        }
        while (j >= mid + 1) {
            copy[copyindex--] = array[j--];
        }
        return (left+right+count)%1000000007;
    }


}
