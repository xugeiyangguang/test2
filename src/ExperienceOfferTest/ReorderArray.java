package ExperienceOfferTest;

public class ReorderArray {
    public static void main(String[] args){
        int[] array = {2,4,6,1,3,5,7};
        reOrderArray(array);
        for (int i:array
             ) {
            System.out.print(i+"\t");
        }
    }
    public static void reOrderArray(int [] array) {
        /*if(array==null&&array.length==0 || array.length==0){
            return;
        }
        int i = 0;
        int j = array.length - 1;
        int temp;
        while(i < j){
            while (i < j && (array[i] & 0x1) == 1){
                i++;
            }
            while (i < j && (array[j] & 0x1) !=1){
                j--;
            }
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }*/
        /*相对位置不变,冒泡排序*/
        int temp;
        for (int i=0; i<array.length - 1; i++){
            for(int j = 0; j<array.length-1;j++){
                if ((array[j] & 0x1) != 1 && (array[j+1] & 0x1) ==1){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return;
    }
}
