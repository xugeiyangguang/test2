package Companies.Else;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LeastCompare {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(s.nextInt());
        }
        Collections.sort(list);
        ArrayList<Integer> re = new ArrayList<>();
        while(list.size()!=0){
            re.add(list.get(0)+list.get(list.size()-1));
            list.remove(0);
            list.remove(list.size()-1);
        }
        Collections.sort(re);
        System.out.println(re.get(re.size()-1)-re.get(0));
    }
}
