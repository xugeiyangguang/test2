package Leetcode;

import java.util.ArrayDeque;

public class A28maxDepth {
    public static void main(String[] args) {
        A28maxDepth test = new A28maxDepth();
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = null;a3.right = null;
        a4.left = null;a4.right = null;
        a5.left = null;a5.right = a6;
        a6.left = null;a6.right = null;
        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        b1.left = b2;b1.right = null;
        b2.left = null;b2.right = null;
        int a = test.maxDepth1(a1);
        System.out.println();
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int curLevelCount = 1;
        int nextLevelCount = 0;
        int deep = 0;
        while (deque.size() != 0){
            TreeNode top = deque.poll();
            if (top.left != null) {
                deque.offer(top.left);
                nextLevelCount++;
            }
            if (top.right != null) {
                deque.offer(top.right);
                nextLevelCount++;
            }
            if (--curLevelCount == 0) {
                deep++;
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
        return deep;
    }
}
