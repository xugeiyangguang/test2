package Companies.Else;

import java.util.Scanner;

public class PlusTree {
    public static void main(String[] args){
        //输入两个字符串，并改为整型数组
        Scanner scanner = new Scanner(System.in);
        String pre = scanner.nextLine();
        String in = scanner.nextLine();
        String[] pre_str = pre.split(" ");
        String[] in_str = in.split(" ");
        int[] pre_arr = new int[pre_str.length];
        int[] in_arr = new int[in_str.length];
        for (int i = 0;i<pre_str.length;i++){
            pre_arr[i] = Integer.valueOf(pre_str[i]);
            in_arr[i] = Integer.valueOf(in_str[i]);
        }
        /*int[] pre_arr = {1,2,3,5,4};
        int[] in_arr = {5,3,2,1,4};*/
        int[] re = new int[pre_arr.length];

        if (pre_arr.length==0){
            System.out.println(0);
            return;
        }
        createTree(re, pre_arr, 0, pre_arr.length - 1, in_arr, 0, in_arr.length - 1);

        for (int i = 0;i<re.length;i++){
            System.out.print(re[i]);
            System.out.print(" ");
        }
    }

    //查找某个数在中序遍历中的位置，返回下标
    public static int find_num(int num,int[] in){
        for(int i=0;i<in.length;i++){
            if(num==in[i]){
                return i;
            }
        }
        return -1;
    }

    //将指定位置的左右两边值都加起来
    public static int total(int[] in,int start,int pos,int end){
        int total = 0;
        for(int i = start;i<pos;i++){
            total+=in[i];
        }
        for(int i = pos+1;i<=end;i++){
            total+=in[i];
        }
        return total;
    }

    public static void createTree(int[] re,int[] pre,int pre_start,int pre_end,int[] in,int in_start,int in_end){
        //如果只有单个数字
        if (in_start>in_end||pre_start>pre_end){
            return;
        }
        if(in_start==in_end){
            re[in_start]=0;
            return;
        }
        int pos = find_num(pre[pre_start],in);
        re[pos] = total(in,in_start,pos,in_end);
        createTree(re,pre,pre_start+1,pre_start+pos-in_start,in,in_start,pos-1);
        createTree(re,pre,pre_start+pos-in_start+1,pre_end,in,pos+1,in_end);
    }
}
