package Companies.Else;

import java.util.Scanner;

public class XYNum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int re = 0;
        for(int x = 1;x<=n;x++){
            for(int y = 1;y<=n;y++){
                if(x<=n && y<=n && x%y>=k){
                    re++;
                }
            }
        }
        System.out.println(re);
    }
}
