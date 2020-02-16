package Companies.Else;

import java.util.ArrayList;
import java.util.Random;

public class SelectOne {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int m =3;
        Random rand = new Random();
        for(int i=0;i<m;i++){
            int index = rand.nextInt(list.size());
            System.out.println(list.get(index));
            list.remove(index);
        }
    }
}
