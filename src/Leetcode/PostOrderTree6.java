package Leetcode;

import javax.swing.border.TitledBorder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class PostOrderTree6 {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = null;a3.right = null;
        a4.left = null;a4.right = null;
        a5.left = null;a5.right = null;
        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        b1.left = b2;b1.right = null;
        b2.left = null;b2.right = null;
        PostOrderTree6 test = new PostOrderTree6();
        ArrayList<Integer> re = test.postorderTraversal2(a1);
        System.out.println();

    }
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();   //采用栈
        deque.push(root);
        TreeNode pre = null;
        while (deque.size() != 0){   //判断栈空不能用null,只能是长度等于0
            TreeNode cur = deque.peek();
            if ((cur.left == null && cur.right == null )
                    || (pre != null &&(pre == cur.left || pre == cur.right)) ){
                result.add(deque.peek().val);
                pre = deque.poll();
            }else {       //让所有节点都全部进栈
                if(cur.right != null)
                    deque.push(cur.right);
                if(cur.left != null)
                    deque.push(cur.left);
            }
        }
        return result;
    }

    //方法二：将先序遍历的结果再反转过来
    public ArrayList<Integer> postorderTraversal2(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();   //采用栈
        deque.push(root);
        while (deque.size() != 0){
            TreeNode temp = deque.peek();
            result.add(temp.val);
            deque.poll();
            if (temp.left != null){
                deque.push(temp.left);
            }
            if (temp.right != null){
                deque.push(temp.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

}
