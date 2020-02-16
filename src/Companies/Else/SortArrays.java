package Companies.Else;

//https://mp.weixin.qq.com/s/vn3KiV-ez79FmbZ36SX9lg

public class SortArrays {
    //从小到大的排序

    public static void main(String[] args) {
        SortArrays test = new SortArrays();
        int[] arr = {1, 4, 2, 3, 6, 5, 0};
        //   test.bubbleSort(arr);
        //test.SelectSort(arr);
        test.Insert(arr);
    }

    public void output(int[] arr) {
        for (int a : arr
        ) {
            System.out.print(a);
        }
        System.out.println();
    }

/*冒泡排序*/

    public void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) {   //表示该次排序没有交换位置
                break;
            }
        }
        System.out.print("冒泡排序的结果为：");
        output(arr);
    }
/*
选择排序

每次在未选择的元素中，选择最小的放在前面*/

    public void SelectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int min_index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_index = j;
                }
            }
            if (min != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
            }
        }
        System.out.print("选择排序的结果为：");
        output(arr);
    }
/*
插入排序

每次从后面开始比较*/

    public void Insert(int[] arr) {
        int[] copy = new int[arr.length];
        copy[0] = arr[0];
        int cur = 1;
        while (cur != arr.length) {
            int last = cur - 1;
            while (last >= 0 && copy[last] > arr[cur]) {
                copy[last + 1] = copy[last];
                last--;
            }
            copy[last + 1] = arr[cur];
            cur++;
        }
        System.out.println("插入排序的结果为：");
        output(copy);
    }
/*
希尔排序*/

    /*public void ShellSort(int[] arr) {
        int d = arr.length / 2;
        while (d != 0) {
            for (int i = 0; i < d - 1; i++) {
                if (arr[i + d] > arr[])
            }
        }
    }*/
}
