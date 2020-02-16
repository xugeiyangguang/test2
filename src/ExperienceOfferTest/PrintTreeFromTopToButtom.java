package ExperienceOfferTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeFromTopToButtom {

    public static void main(String[] args){
        PrintTreeFromTopToButtom test = new PrintTreeFromTopToButtom();
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(8);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(9);
        TreeNode a5 = new TreeNode(2);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a5.left = a6;
        a5.right = a7;
        a3.left = null;a3.right = null;
        a4.left = null;a4.right = null;
        a6.left = null;a6.right = null;
        a7.left = null;a7.right = null;
        TreeNode b = new TreeNode(8);
        TreeNode b1 = new TreeNode(9);
        b.left = null;b.right = b1;
        b1.left = null;b1.right = null;
        ArrayList<Integer> result = test.PrintFromTopToBottom(b);
        if(result != null){
            for (int i:result
            ) {
                System.out.print(i);
            }
        }

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        TreeNode temp;
        ArrayList<Integer> result = new ArrayList<>();  //最后输出的顺序节点值，里面是值

        LinkedList<TreeNode> q = new LinkedList<>(); //中间队列，存储的是节点
        q.add(root);
        while (q.size()!=0){  //队列不为空
            temp = q.removeFirst();
            result.add(temp.val);
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
        return result;
    }

}
