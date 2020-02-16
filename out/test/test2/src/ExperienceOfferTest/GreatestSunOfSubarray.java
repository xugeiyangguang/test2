package ExperienceOfferTest;

public class GreatestSunOfSubarray {
    boolean InvalidInput = false;
    public static void main(String[] args){
        GreatestSunOfSubarray test = new GreatestSunOfSubarray();
        int[] array = {1,-2,3,10,-4,7,2,-5};
        System.out.println(test.FindGreatestSumOfSubArray(array));
    }
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0){
            InvalidInput = true;
            return -1;
        }
        InvalidInput = false;
        int max = 0x80000000;
        int currentMax = 0;
        for (int i = 0; i<array.length; i++){
            /*if (currentMax <= 0){
                currentMax = array[i];
            }else {
                currentMax += array[i];
            }
            if (currentMax > max){
                max = currentMax;
            }*/
            currentMax = currentMax+array[i];
            if(currentMax >max){max = currentMax;}
            if(currentMax<array[i] && array[i] > max){
                max = array[i];
                currentMax = array[i];
            }
        }
        return max;
    }
}
