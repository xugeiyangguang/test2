package Companies.Else;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MinNum {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("3");
        list.add("32");
        list.add("321");
/*        Collections.sort(list,new Comparator<String>(){
            public int compare(String a,String b){
                String a1 = a + b;
                String a2 = b + a;
                return a1.compareTo(a2);
            }
        });*/
        Collections.sort(list, (a, b) -> {
            String a1 = a + b;
            String a2 = b + a;
            return a1.compareTo(a2);
        });
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
    }
}
