package ExperienceOfferTest2;

public class A36_InversePairs {
    public static void main(String[] args) {
        A36_InversePairs test = new A36_InversePairs();
        int[] array = {2, 4, 3, 1};
        int re = test.InversePairs(array);
        System.out.println();
    }
    public int InversePairs(int [] array) {
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

    public int InversePairsCore(int[] array, int[] copy, int start, int end) {
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
