package Companies.Else;

import java.util.Random;

public class SelectNum {
    public static void main(String[] args){
        int n = 6;
        int m = 7;
        for(int i=0;i<3;i++){
            Core(n,m);
        }

    }
    public static void Core(int n,int m){
        int total =0;
        Random rand = new Random();
        for(int i=0;i<m;i++){
            total+=rand.nextInt(n);
        }
        System.out.println(total%m+1);
    }
}
