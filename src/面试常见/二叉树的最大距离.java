package 面试常见;

import Companies.Pdd.Tree;

public class 二叉树的最大距离 {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(8);
        TreeNode a9 = new TreeNode(9);
        a1.left = a2;
        a1.right = a6;
        a2.left = a3;
        a2.right = a5;
        a6.left = a7;
        a6.right = a8;
        a3.left = a4;
        a3.right = null;
        a5.left = null;
        a5.right = null;
        a7.left = null;
        a7.right = a9;
        a8.left = null;
        a8.right = null;
        a4.left = null;
        a4.right = null;
        a9.left = null;
        a9.right = null;

        int re = func(a1);
        System.out.println();

    }

    public static int func(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //情况A:路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。
        //只需要知道左右子树的深度，然后加起来即可
        int leftDeep = getDeep(root.left);
        int rightDeep = getDeep(root.right);
        int one = leftDeep + rightDeep;

        //情况B: 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者
        int two = Math.max(func(root.left), func(root.right));
        return Math.max(one, two);
    }

    public static int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDeep(root.left), getDeep(root.right)) + 1;
    }
}
