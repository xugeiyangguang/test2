package Companies.Liulishuo;

import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0) {

            System.out.println(0);
            return;
        }
        if (n == 1) {

            System.out.println(1);
            return;
        }
        if (n == 2) {

            System.out.println(2);
            return;
        }
        if(n>2){
            int[] r = new int[n];
            r[0] =1;
            r[1]=2;
            for(int i=2;i<n;i++){
                r[i] = r[i-1]+r[i-2];
            }
            System.out.println(r[n-1]);
        }
    }

}
