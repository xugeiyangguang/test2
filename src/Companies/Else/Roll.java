package Companies.Else;

import java.util.ArrayList;
import java.util.Scanner;

public class Roll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        //颜色从第一位存储,0位没用,透明的颜色
        for (int k = 0; k <= c; k++) {
            ArrayList<Integer> temp = new ArrayList<>();
            re.add(temp);
        }
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            for (int j = 0; j < num; j++) {
                re.get(scanner.nextInt()).add(i + 1);

            }
        }
        //有问题的颜色数量
        int count = 0;

        for (int i = 1; i <= c; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            int size = re.get(i).size();
            for (int j = 1; j < size; j++) {
                if (j < size - 1 && re.get(i).get(j) - re.get(i).get(j) > m) {
                    count++;
                    break;
                }
                if (j == size - 1 && re.get(i).get(j) + n - re.get(i).get(0) > m) {
                    count++;
                    break;
                }
            }


        }
        System.out.println(count);

    }
}
