package Companies.JingDong;

import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;
public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] heights = new int[num];
        for(int i =0;i<num;i++){
            heights[i] = in.nextInt();
        }
        System.out.println(find(heights));
    }
    public static int find(int[] heights){
        if(heights.length==1)
            return 1;
        if(heights.length==2){
            if(heights[0]>heights[1])
                return 1;
            else
                return 0;
        }
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0;i<heights.length;i++){
            if(heights[i]<min){
                min = heights[i];
                index = i;
            }
        }
        return 1+find(Arrays.copyOfRange(heights,index+1,heights.length));

    }
}

