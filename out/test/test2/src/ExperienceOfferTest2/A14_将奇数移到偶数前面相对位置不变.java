package ExperienceOfferTest2;

import java.util.ArrayList;

public class A14_将奇数移到偶数前面相对位置不变 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray(array);
        System.out.println();
    }
    public static void reOrderArray(int [] array) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(array[i]%2==1){
                //a中存放奇数
                a.add(array[i]);
            }else{
                b.add(array[i]);
            }
        }
        for(int i=0;i<array.length;i++){
            if(a.size()!=0){
                array[i] = a.remove(0);
            }else{
                array[i] = b.remove(0);
            }
        }
    }
}
