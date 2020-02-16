package ExperienceOfferTest;

import java.util.ArrayList;
//可以新建一个有长度参数的方法
public class SquenceOfBST {
    public static void main(String[] args){
        int[] sequence = {5,12,6,9,11,10,8};
        System.out.print(VerifySquenceOfBST(sequence));
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        int last = sequence.length - 1; //后序遍历最后一个元素
        int i = 0;
        //将左子树存到动态数组中
        for(; sequence[i]<sequence[last] && i < sequence.length ; i++){
            left.add(sequence[i]);
        }
        //将Array动态数组转化为int[]
        int[] leftArray = new int[i];
        for (int l = 0;l < i; l++){
            leftArray[l] = left.get(l);
        }
        int j = i;

        //将右子树存到动态数组中
        while (j < last){
            right.add(sequence[j]);
            if(sequence[j] < sequence[last]){
                return false;
            }
            j++;
        }

        //将Array动态数组转化为int[]
        int[] rightArray = new int[right.size()];
        for (int l = 0;l < right.size(); l++){
            rightArray[l] = right.get(l);
        }

        boolean leftVal = true;
        if(i>0){
            leftVal = VerifySquenceOfBST(leftArray);
        }
        boolean rightVal = true;
        if(i < sequence.length-1){
            rightVal = VerifySquenceOfBST(rightArray);
        }
        return leftVal&&rightVal;
    }
}
