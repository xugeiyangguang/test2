package ExperienceOfferTest2;

public class A14_将奇数移到偶数前面 {
    public static void main(String[] args) {
        A14_将奇数移到偶数前面 test = new A14_将奇数移到偶数前面();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        test.reOrderArray(array);
        System.out.println();
    }
    //书上要求的，相对位置会有变化
    public  void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int start = 0; //指向偶数序列的第一位
        int index = 0;
        while (index < array.length) {
            if (index != start && (array[index] & 0x1) == 1) {
                int temp = array[index];
                array[index] = array[start];
                array[start] = temp;
            }
            if ((array[start] & 0x1) == 1) {
                start++;
            }
            index++;
        }
    }
}
