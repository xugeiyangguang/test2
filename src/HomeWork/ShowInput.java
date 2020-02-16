package HomeWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShowInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (!input.hasNext("#")) {
            list.add(input.nextInt());
        }
        Collections.sort(list);
        System.out.println(list);
    }
}
