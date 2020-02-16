package Companies.Else;

import java.util.ArrayList;
import java.util.Arrays;

public class TreeSumLeast {
    public static void main(String[] args) {
        TreeSumLeast test = new TreeSumLeast();
        int[] sum = {-1, 2, 1, -4};
        int re = test.threeSumClosest(sum, 3);
        System.out.println();

    }
    public int threeSumClosest(int[] num, int target) {
        if(num.length<3){
            return 0;
        }
        Arrays.sort(num);
        ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<num.length;i++){
            int rest = 0-num[i];
            int left = 0;
            int right = num.length-1;
            while(left<right){
                int tmp = num[left]+num[right]+num[i];
                int t = Math.abs(target-tmp);
                min = Math.min(min,t);
                if(tmp==target){
                    return target;
                }
                if(num[left]+num[right]>rest){
                    right--;
                }else if(num[left]+num[right]<rest){
                    left++;
                }
            }
        }
        return min+target;
    }
}
