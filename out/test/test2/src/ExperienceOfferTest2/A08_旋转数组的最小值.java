package ExperienceOfferTest2;

public class A08_旋转数组的最小值 {
    public static void main(String[] args) {
        A08_旋转数组的最小值 test = new A08_旋转数组的最小值();
        int[] array = {3, 4, 5, 1, 2};
        int[] array1 = {5, 1, 2, 3, 4};
        System.out.println(test.minNumberInRotateArray(array1));

    }
    /*public int minNumberInRotateArray1(int [] array) {
        if (array == null|| array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        //先判断是不是旋转数组
        while (array[left] >= array[right]) {
            int mid = (left + right) >> 1;
            *//*判断是不是不能用二分法解决的*//*
            if (array[left] == array[mid]) {
                InOder(array);
            }
            if (left == mid) {
                return Math.min(array[right], array[left]);
            }
            if (array[left] < array[mid]) {
                left = mid;
            }
            if (array[left] > array[mid]) {
                right = mid;
            }
        }
        return array[left];
    }*/
    public int minNumberInRotateArray(int [] array) {
        if (array == null && array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid;
        while (array[left] >= array[right]) {
            if (left + 1 == right) {
                return array[right];
            }
            mid = (left + right) / 2;
            if (array[left] == array[mid] && array[mid] == array[right]) {
                return InOder(array);
            }
            if (array[left] <= array[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[right];
    }

    public int InOder(int[] array) {
        int i = Integer.MAX_VALUE;
        for (int j : array) {
            if (j < i) {
                i = j;
            }
        }
        return i;
    }
}
