package Companies.Else;

import java.util.Scanner;

public class LeastStep {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int dis = s.nextInt();
        int cur = 1;
        int total = 0;
        while(true){
            total+=cur;
            if(total>=dis&&(total-dis)%2==0){
                System.out.println(cur);
                return;
            }
            cur++;
        }
    }
}
