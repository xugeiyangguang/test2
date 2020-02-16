package ExperienceOfferTest;

public class MoreThanHalfNumber{
    public static void main(String[] args){
        MoreThanHalfNumber r = new MoreThanHalfNumber();
        int[] array = {1,9,3,2,2,2,5,4,2};
        System.out.println(r.MoreThanHalfNum_Solution(array));
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length ==0){
            return -1;
        }
        int left = 0;
        int right = array.length-1;
        int mid = array.length>>1;
        int index = SortFunction.Partition1(array,left,right);
        while (index!=mid){
            if(index<mid){
                left = index+1;
            }else {
                right = index-1;
            }
            index = SortFunction.Partition1(array,left,right);

        }
        if(!IsValid(array,array[index])){
            return 0;
        }
        return array[index];
    }

    /*public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length ==0){
            return -1;
        }
        int count = 0;
        int result = array[0];
        for (int i=1; i<array.length; i++ ){
            if(array[i] == result){
                count++;
            }else{
                if(count == 0){
                    result = array[i];
                }else{
                    count --;
                }
            }
        }
        if(!IsValid(array,result)){
            return 0;
        }
        return result;
    }*/

    public boolean IsValid(int[] array,int result){
        int time = 0;
        for(int i = 0; i<array.length; i++){
            if(array[i]==result){
                time++;
            }
        }
        if(time<=array.length>>1){
            return false;
        }
        return true;
    }
}
