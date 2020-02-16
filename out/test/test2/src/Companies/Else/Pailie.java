package Companies.Else;

import java.util.ArrayList;
import java.util.Collections;

public class Pailie {
    static ArrayList<String> re = new ArrayList<>();
    public static void main(String[] args) {
        String strs = "aa";
        re = Permutation(strs);
        System.out.println();
    }
    public static ArrayList<String> Permutation(String str) {
        char[] a = str.toCharArray();
        func(a,0);
        Collections.sort(re);
        return re;
    }
    public static void func(char[] a,int start){
        if(start==a.length-1){
            String i = String.valueOf(a);
            if(!re.contains(i)){
                re.add(i);
            }
            return;
        }
        for(int i=start;i<a.length;i++){
            char tmp = a[i];
            a[i] = a[start];
            a[start] = tmp;

            func(a,start+1);

            tmp = a[i];
            a[i] = a[start];
            a[start] = tmp;

        }

    }
}
