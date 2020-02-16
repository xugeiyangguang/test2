package Companies.Pdd;

import java.util.Scanner;

public class Tree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String[] arr = a.split(" ");
        String b = s.nextLine();
        String[] brr = b.split(" ");

        int[] aa = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            aa[i] = Integer.valueOf(arr[i]);
        }
        int[] bb = new int[brr.length];
        for (int i = 0; i < brr.length; i++) {
            bb[i] = Integer.valueOf(brr[i]);
        }

        int index = -1;
        for (int i=0;i<aa.length-1;i++){

            if (aa[i]>=aa[i+1]){
                index = i+1;
                break;
            }
        }



        int flag = 0;
        for (int i = bb.length-1;i>=0;i--){
            if(index<aa.length-1&&index>0){
                if(bb[i]>aa[index-1]&&bb[i]<aa[index+1]){
                    if (flag == 0) {
                        aa[index] = bb[i];
                        flag = 1;
                    } else {
                        aa[index] = Math.max(bb[i], aa[index]);

                    }

                }
            }else if(index==0){
                if (bb[i] < aa[index + 1]) {
                    if (flag == 0) {
                        aa[index] = bb[i];
                        flag = 1;
                    } else {
                        aa[index] = Math.max(bb[i], aa[index]);

                    }
                }
            } else if (index == aa.length - 1) {
                if (bb[i] > aa[index - 1]) {
                    if (flag == 0) {
                        aa[index] = bb[i];
                        flag = 1;
                    } else {
                        aa[index] = Math.max(bb[i], aa[index]);

                    }
                }
            }

        }

        if (flag != 0) {
            for (int i = 0; i < aa.length; i++) {
                System.out.print(aa[i] + " ");
            }
        } else {
            System.out.println(false);
        }

    }
}
