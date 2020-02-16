package ExperienceOfferTest;

public class Power {
    public static void main(String[] args){
        System.out.println(Power(2.0,-1));
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
        /*指数是负数*/
        if(isNegative == 1){
            result = 1.0 / result;
        }
        return result;
    }
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
