package Leetcode;

import java.util.ArrayDeque;
import java.util.regex.Matcher;

public class MinimumDepthOfTree {
    public static void main(String[] args) {
        MinimumDepthOfTree test = new MinimumDepthOfTree();
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

        System.out.println(test.run(a1));
    }
    public int run(TreeNode root) {
        if (root == null){
            return 0;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int depth = 0;
        int len;
        while (deque.size() != 0){
            depth++;
            len = deque.size();
            TreeNode curNode = deque.getFirst();
            for (int i = 0; i < len; i++){
                if (curNode.right == null && curNode.left == null){
                    return depth;
                }
                if (curNode.right != null){
                    deque.offer(curNode.right);
                }
                if (curNode.left != null){
                    deque.offer(curNode.left);
                }
                if (curNode.right == null && curNode.left == null){
                    return depth;
                }
                deque.poll();
            }
        }
        return depth;
    }

    /*
    public int run(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null ){
            return run(root.right) + 1;
        }else if (root.right == null){
            return run(root.left) + 1;
        }else {
            return Math.min(run(root.left),run(root.right))+1;
        }
    }
    */
}
