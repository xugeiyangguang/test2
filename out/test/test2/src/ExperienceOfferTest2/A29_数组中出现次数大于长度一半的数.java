package ExperienceOfferTest2;

public class A29_数组中出现次数大于长度一半的数 {
    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        A29_数组中出现次数大于长度一半的数 test = new A29_数组中出现次数大于长度一半的数();
        int re = test.MoreThanHalfNum_Solution(array);
        System.out.println();
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length ==0){
            return -1;
        }
        int left = 0;
        int right = array.length-1;
        int mid = array.length>>1;
        int index = partition(array,left,right);
        while (index!=mid){
            if(index<mid){
                left = index+1;
            }else {
                right = index-1;
            }
            index = partition(array,left,right);

        }
        if(!checkMoreThanHalf(array,array[index])){
            return 0;
        }
        return array[index];
    }
    public int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int piriot = array[left];
        while (i < j) {
            while (i < j && array[j] >= piriot) {
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] <= piriot) {
                i++;
            }
            array[j] = array[i];
        }
        array[j] = piriot;
        return j;
    }
    public int MoreThanHalfNum_Solution1(int [] array) {
        if (!checkArrayValid(array)) {
            return -1;
        }
        int base = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == base) {
                count++;
            } else {
                if (count == 0) {
                    base = array[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        if (!checkMoreThanHalf(array,base)) {
            return -1;
        }
        return base;

    }

    public boolean checkArrayValid(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        return true;
    }

    public boolean checkMoreThanHalf(int[] array, int number) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return true;
        }
        return false;
    }
}
