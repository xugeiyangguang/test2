package Companies.Pdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String b=sc.nextLine();
        String [] c = b.split("\\s+");
        System.out.println(pdd1(c));
    }
    public static Boolean  pdd1(String [] c) {
        if (c.length<=0){
            return false;
        }
        if (c.length==1){
            return false;
        }
        int k = 0;
        int j = 0;
        int l = 0;
        Boolean flag=true;
        for (int i = 0; i < c.length-1; i++) {
            String s = c[i];

            k = i + 1;

//            j = k + 1;
            l = c[i].length();
            String  E= c[i].substring(l - 1, l);
 //           String B = c[i].substring(0, 1);
  //          String tt=c[k].substring(0, 1);
            while (k <= c.length-1 && (!E .equals(c[k].substring(0, 1)))) {
                k = k + 1;
//                if (k>c.length-1){
//                  break;
//                }
            }
            if (k > c.length-1) {
                flag =false;
                break;
            }else {

                String temp=c[i+1];
                c[i+1]=c[k];
                c[k]=temp;
            }

        }
        String a=c[c.length-1].substring(c[c.length-1].length()-1,c[c.length-1].length());
        if (!c[0].substring(0,1).equals(a)){
            flag=false;
        }
        return flag;
    }

}
