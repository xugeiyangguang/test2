/*
package ExperienceOfferTest2;

public class A31_连续子序列的最大和 {
    public static void main(String[] args) {
        A31_连续子序列的最大和 test = new A31_连续子序列的最大和();
        int[] array = {-4, -3, -2, -1};
        int re = test.FindGreatestSumOfSubArray(array);
        System.out.println();
    }
    boolean InvalidInput = false;
    public int FindGreatestSumOfSubArray1(int[] array) {
        if (array == null || array.length == 0){
            InvalidInput = true;
            return -1;
        }
        InvalidInput = false;
        int max = 0x80000000;
        int currentMax = 0;
        for (int i = 0; i<array.length; i++){
            */
/* 书上的方法，对当前和进行了符号判断
            if (currentMax <= 0){
                currentMax = array[i];
            }else {
                currentMax += array[i];
            }
            if (currentMax > max){
                max = currentMax;
            }*//*

            //先把当前的数加上
            currentMax = currentMax+array[i];
            if(currentMax >max){max = currentMax;}
            if(currentMax<array[i] && array[i] > max){
                max = array[i];
                currentMax = array[i];
            }
        }
        return max;
    }
    //时间复杂度是n^2：找每个下标最大的序列
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = -999;
        for (int index = 0; index < array.length; index++) {
            //如果当前位为正数
            if (array[index] > 0) {
                int pos = index;
                int temp = 0;
                while (pos < array.length && array[pos] + temp > 0) {
                    temp += array[pos];
                    max = Math.max(temp, max);
                    pos++;
                }
            //如果当前位为负数
            } else {
                //如果下一位比它小
                if (((index + 1) < array.length && array[index + 1] < array[index]) || index == array.length - 1) {

                    max = Math.max(max, array[index]);
                }
                //如果下一位比它大，直接不考虑
            }
        }
        return max;
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i=0;i<array.length;i++){
            if(curSum<0){
                curSum = array[i];

            }else{
                curSum+=array[i];

            }
            max = Math.max(max,curSum);
        }
        return max;
    }
}
*/
