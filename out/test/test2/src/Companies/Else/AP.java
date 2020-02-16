package Companies.Else;

import java.util.Scanner;

public class AP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 1) {
            System.out.println(1);
        }
        int two = n * (n - 1) / 2;
        System.out.println(two + n + 1);
    }


}
