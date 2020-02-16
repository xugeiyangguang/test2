package Companies.Pdd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String[] b = a.substring(1,a.length()-1).split(",");
        int[] c = new int[b.length];
        for(int i=0;i<c.length;i++){
            c[i] = Integer.valueOf(b[i]);
        }
        if(c.length==1)
            return;
     //   in.nextLine();
        int target = Integer.valueOf(in.nextLine());
        int i=0,j=c.length-1;
        while(i<=j){
            if(c[i]+c[j]==target){
                System.out.println(c[i]+","+c[j]);
                i++;
            }
            else if(c[i]+c[j]<target){
                i++;
            }else {
                j--;
            }
        }
    }

}
