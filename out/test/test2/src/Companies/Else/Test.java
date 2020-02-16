package Companies.Else;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        /*对象数组转换为ArrayList*/
        String[] array=new String[3];
        array[0]="a";
        array[1]="b";
        array[2]="c";
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
        System.out.println(arrayList);

        /*ArrayList转为对象数组*/

        String[] array2 = arrayList.toArray(new String[arrayList.size()]);
        for (String s: array2
             ) {
            System.out.print(s);
        }

    }
}
