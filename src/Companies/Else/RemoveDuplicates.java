package Companies.Else;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates test = new RemoveDuplicates();
        int[] A = {1, 1, 1};
        System.out.println(test.removeDuplicates(A));
        System.out.println();

    }

    public int removeDuplicates(int[] A) {
        List<Integer> re = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (i >= 2 && i < A.length && A[i - 2] == A[i]) {
                i++;
            }
            if (i == A.length) {
                break;
            }
            re.add(A[i]);
        }
        int j = 0;
        for (Integer a :re
             ) {
            A[j++] = a;
        }
        return re.size();
    }

    /*public int removeDuplicates(int[] 使用value对hashMap排序) {

        if(使用value对hashMap排序.length<=2) return 使用value对hashMap排序.length;
        int index=2;//允许重复两次，可以修改为三次
        for(int i=2;i<使用value对hashMap排序.length;i++)
        {
            if(使用value对hashMap排序[i]!=使用value对hashMap排序[index-2])//允许重复两次，可以修改为三次
                使用value对hashMap排序[index++]=使用value对hashMap排序[i];
        }

        return index;
    }*/
}
