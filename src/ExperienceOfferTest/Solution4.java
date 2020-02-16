package ExperienceOfferTest;

import ExperienceOfferTest.TreeNode;
/*根据前序和中序重构二叉树，，前提是节点不能重复*/
public class Solution4 {
    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode result = reConstructBinaryTree(pre,in);
        System.out.println(result.val);
        show(result);
    }
    public static int show(TreeNode r){
        if(r!=null){
           show(r.left);
           System.out.println(r.val);
           show(r.right);
        }
        return -1;
    }
    public  static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int i=0;
        int j;
        TreeNode t = new TreeNode(0);
//        数组判断非空的条件
        if((pre  == null ||pre.length == 0 )&&(in == null||in.length == 0)){
            return null;
        }else{
            t.val = pre[i];  /*将前序遍历的第一个节点作为根节点*/
            j = findNumIndex(in,pre[i]);   /*在中序遍历中找到根节点的位置*/
            if (j == in.length-1){  /*没有右子树*/
                t.right = null;
                t.left = reConstructBinaryTree(getSubArray(pre,1,j),getSubArray(in,0,j-1));
            }else if(j == 0){    /*没有左子树*/
                t.left =null;
                t.right = reConstructBinaryTree(getSubArray(pre,1,pre.length-1),getSubArray(in,1,pre.length-1));
            }else{
                t.left = reConstructBinaryTree(getSubArray(pre,1,j),getSubArray(in,0,j-1));
                t.right = reConstructBinaryTree(getSubArray(pre,j+1,pre.length-1),getSubArray(in,j+1,in.length-1));
            }
            return t;
        }

    }
    public static int findNumIndex(int [] arr,int k){
        for (int i=0; i<arr.length; i++){
            if(arr[i] == k){
                return i;
            }
        }
        return -1;
    }
    static int[] getSubArray(int[] arr,int begin, int last){
        int len = last - begin + 1;
        int[] subArray = new int[len];
        int j = 0;
        for(int i=begin; i<=last;){
            subArray[j++] = arr[i++];
        }
        return subArray;
    }
}
