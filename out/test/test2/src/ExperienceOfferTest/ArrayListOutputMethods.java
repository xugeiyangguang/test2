package ExperienceOfferTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListOutputMethods {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.print("数组链表ArrayList的不同输出方式：");
        System.out.print("\n第1种：");
        for (int i:list
             ) {
            System.out.print(i);
        }
        System.out.print("\n第2种：");
        for(int i = 0;i<list.size(); i++){
            System.out.print(list.get(i));
        }
        System.out.print("\n第3种：");
        Iterator i = list.iterator();
        while (i.hasNext()){
            System.out.print(i.next());
        }
        System.out.print("\n第4种：");
        for(Iterator i2 = list.iterator();i2.hasNext();){
            System.out.print(i2.next());
        }
    }
}
