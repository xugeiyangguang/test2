package ExperienceOfferTest;

/**
 * 用排列的方式输出n位数
 * **/
public class Print1ToMaxOfNDigits {
    public static void main(String[] args){
        print1ToMaxOfNDigits(0);
    }
    public static void print1ToMaxOfNDigits(int n){
        if(n<=0){
            return;
        }
        /*用一个int数据表示一个数字，但是int是4个字节，由于32位，能表示32^2个字符，
        但是十进制数字只有0-9，这样没有充分利用内存，char同理*/
        int[] number = new int[n];
        for(int i = 0; i<10; i++){
            number[0] =i;
            Print1ToMaxOfNDigitsRecursively(number,n,0);
        }
    }
    public static void Print1ToMaxOfNDigitsRecursively(int[] number,int length,int index){
        if(index == length -1){
            PrintNumber(number);
            return;
        }
        System.out.println();
        for (int i=0; i<10; i++){
            number[index+1] = i;
            Print1ToMaxOfNDigitsRecursively(number,length,index+1);
        }
    }
    public static void PrintNumber(int[] number){
        boolean isBeginning0 = true;
        int nLength = number.length;

        for(int i = 0; i<nLength; i++){
            if(isBeginning0 && number[i]!=0){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.print("\t");
    }
}
