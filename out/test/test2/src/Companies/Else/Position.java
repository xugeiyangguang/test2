package Companies.Else;

import java.util.Scanner;

public class Position {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String s = scanner.next();
        char[] arr = {'N','E','S','W'};
        int pos = 0;
        for(int i=0;i<num;i++){
            if(s.charAt(i)=='L'){
                pos = (pos+4-1)%4;
            }else{
                pos = (pos+1)%4;
            }
        }
        System.out.println(arr[pos]);
    }
}
