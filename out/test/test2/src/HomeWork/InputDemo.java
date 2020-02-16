package HomeWork;

import java.util.Scanner;

public class InputDemo {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int all = 0;
        for (int i = 0; i < 10; i++){
            Scanner scanner = new Scanner(System.in);
            arr[i] = scanner.nextInt();
            all += arr[i];
        }
        System.out.println("数组的值为：");
        for (int a:arr
             ) {
            System.out.print(a + " ");
        }
        System.out.println("数组的平均值为：" + all/arr.length);

    }
}
