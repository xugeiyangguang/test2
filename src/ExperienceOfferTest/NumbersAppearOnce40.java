package ExperienceOfferTest;

public class NumbersAppearOnce40 {
    public static void main(String[] args) {
        NumbersAppearOnce40 test = new NumbersAppearOnce40();
        int[] array = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        test.FindNumsAppearOnce(array,num1,num2);
        System.out.println();
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null||array.length==0){
            return;
        }
        int total= 0;
        for (int i=0;i<array.length;i++){
            total+=array[i];
        }
        String s = Integer.toBinaryString(total);
        System.out.println(s);
        int fristOne = findFristOne(s);
        System.out.println(fristOne);
        for (int i:array
             ) {
            if ((i>>(s.length()-fristOne-1)&1)==0){  //如果那位是0，划分到0组
                num1[0]^=i;
            }else {    //如果那位是1
                num2[0]^=i;
            }
        }
    }
    public int findFristOne(String s){
        for (int i = s.length()-1; i>=0;i--){
            if (s.charAt(i)=='1'){
                return i;
            }
        }
        return -1;
    }
}
