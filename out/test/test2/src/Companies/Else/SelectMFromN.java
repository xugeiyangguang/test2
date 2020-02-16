package Companies.Else;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*求数组的全部组合*/
public class SelectMFromN {
    static ArrayList<ArrayList<Character>> re = new ArrayList<>();
    static ArrayList<Character> tmp = new ArrayList<>();
    public static void main(String[] args){

        ArrayList<Character> list = new ArrayList<>();
        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5');
        func(list,0,list.size());
        for(int i=0;i<re.size();i++){
            for(int j=0;j<re.get(i).size();j++){
                System.out.print(re.get(i).get(j));
            }
            System.out.println();
        }

    }
    public static void func(ArrayList list,int start,int m){
        if (start >= list.size() || m == 0) {
            ArrayList<Character> a = new ArrayList<>(tmp);
            /*可以在这里限制组合的长度大小*/
            if (!re.contains(a)) {

                re.add(a);
            }
            return;
        }
        func(list,start+1,m);
        tmp.add((Character)list.get(start));
        func(list,start+1,m - 1);

    }
}
