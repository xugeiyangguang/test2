package Companies.Else;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class dengcha {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();

        ArrayList<Integer> x = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            System.out.println(scanner.nextLine());
            x.add(scanner.nextInt());
        }
        Collections.sort(x);
        int d = x.get(1) - x.get(0);
        for(int i=1;i<x.size()-1;i++){
            if(x.get(i+1)-x.get(i)!=d){
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }
}
