package Companies.Else;

import java.util.Scanner;

public class NumberOf3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int start = (1 + l -1)*(l-1)/2; // 右边整数的各位和
        int count = 0;
        for(int i = l;i<=r;i++){
            if((start + i)%3==0){
                count++;
            }
            start += i;
        }
        System.out.println(count);
    }
}
