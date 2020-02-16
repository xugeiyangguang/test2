/*
package Companies.ShangTang;

import java.math.BigInteger;
import java.util.Scanner;

public class big {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        BigInteger a = in.nextBigInteger();
        BigInteger b = in.nextBigInteger();
        BigInteger c = in.nextBigInteger();
        BigInteger f0 = in.nextBigInteger();
        if(n.compareTo(BigInteger.ZERO)<0)
            System.out.println(0);
        else if(n.compareTo(BigInteger.ZERO)==0)
            System.out.println(f0);
        else {
            BigInteger temp0 = f0;
            BigInteger temp1 = a.multiply(f0).add(new BigInteger("32768"));
            BigInteger temp2 = temp1.multiply(a).add(b.multiply(f0)).add(new BigInteger("32773"));
            if(n.compareTo(BigInteger.ONE)==0)
                System.out.println(temp1);
            if(n.compareTo(new BigInteger("2"))==0)
                System.out.println(temp2);
            else{
                BigInteger res = new BigInteger("0");
                for(int i=3;i<=n;i++){
                    res = a*temp2+b*temp1+c*temp0+2*i*i-i+32767;
                    temp0 = temp1;
                    temp1 = temp2;
                    temp2 = res;
                }
                System.out.println(res%1000000007);
            }
        }
    }

}
*/
