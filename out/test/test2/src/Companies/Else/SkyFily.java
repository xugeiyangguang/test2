package Companies.Else;

import java.util.HashMap;
import java.util.Scanner;

public class SkyFily {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        int start = scanner.nextInt();

        int[] arr =  new int[times];
        for(int i = 0;i<times;i++){
            arr[i] = scanner.nextInt();
            if (start - arr[i] < 0) {
                System.out.println(i);
                return;
            }
            start -= arr[i];
        }
        System.out.println(times);
        /*int i = 0;

        while(start>0){
            if(start>=arr[i]&&i<times){
                start-=arr[i];
                i++;
            }else {
                break;
            }

        }
        System.out.println(i);*/
    }
}
