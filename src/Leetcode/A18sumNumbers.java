package Leetcode;

import javax.naming.InitialContext;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 1.先序遍历将每个节点加入栈中
 * 2.当遇到叶子节点就倒序打印栈中的内容，并将叶子节点出栈
 * 3.当该节点的子节点都被访问过，则将该节点出栈
 * 4.将每次栈中数据加起来
 */
public class A18sumNumbers {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(0);
        TreeNode a4 = new TreeNode(1);
        a1.left = a2;
        a1.right = a3;
        a2.left = null;
        a2.right = a4;
        a3.left = null;
        a3.right = null;
        a4.left = null;
        a4.right = null;
        A18sumNumbers test = new A18sumNumbers();

        int re = test.sumNumbers1(a1);
        System.out.println();
    }
    public static TreeNode pre = null;
    public int sumNumbers(TreeNode root) {
        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        int[] re = new int[1];
        InOderTranverse(root,s,re);

        return re[0];
    }
    public void InOderTranverse(TreeNode root,ArrayDeque<TreeNode> s,int[] re){
        if (root == null){
            return;
        }
        s.push(root);
        if (root.left != null){
            InOderTranverse(root.left,s,re);
        }
        if (root.right != null){
            InOderTranverse(root.right,s,re);
        }
        if (root.left == null && root.right == null){
            printStack(s,re);
            pre = s.poll();
            return;
        }
        if (pre == s.peek().right || pre == s.peek().left){
            pre = s.poll();
            return;
        }
    }
    public void printStack(ArrayDeque<TreeNode> s,int[] re){
        ArrayDeque<TreeNode> s1 = new ArrayDeque<>();
        StringBuilder str = new StringBuilder();
        while (s.size() !=0){
            str.append(s.peek().val);
            s1.push(s.poll());
        }
        str.reverse();
        re[0] += Integer.valueOf(str.toString());
        while (s1.size() != 0){
            s.push(s1.poll());
        }
    }

    //方法二：先序遍历的思想(根左右)+数字求和(每一层都比上层和*10+当前根节点的值)
    public int sumNumbers1(TreeNode root) {
        int sum = 0;
        return PreTranverse(root,sum);
    }
    public int PreTranverse(TreeNode root,int sum){
        if (root == null){
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null){
            return sum;
        }
        return PreTranverse(root.left,sum) + PreTranverse(root.right,sum);
    }
}
