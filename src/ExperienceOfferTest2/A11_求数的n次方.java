package ExperienceOfferTest2;

public class A11_求数的n次方 {
    public static void main(String[] args) {
        A11_求数的n次方 test = new A11_求数的n次方();
        double base = 2;
        int exponent = 8;
        double re = PowerWithUnsignedExponent(base, exponent);
        System.out.println();
    }
    static boolean InvalidInput = false;
    public static double Power(double base, int exponent) {
        if (equal(base,0.0)&&exponent < 0){
            InvalidInput = true;
            return 0.0;
        }
        int isNegative = exponent<0 ? 1:0;
        int newExponent = Math.abs(exponent);
        double result = PowerWithUnsignedExponent(base,newExponent);
        if(isNegative == 1){
            result = 1.0 / result;
        }
        return result;
    }

    /*标准*/
    public static double PowerWithUnsignedExponent(double base,int newExponent){
        if(newExponent==0){
            return 1;
        }
        if(newExponent==1){
            return base;
        }
        double result = PowerWithUnsignedExponent(base,newExponent>>1);
        result *= result;
        if((newExponent & 0x1) == 1){   /*==的优先级高于&*/
            result *= base;
        }
        return result;
    }
    public static boolean equal(double a,double b){
        if(a-b < 0.0000001 && a-b > -0.0000001){
            return true;
        }
        else{
            return false;
        }
    }
}
