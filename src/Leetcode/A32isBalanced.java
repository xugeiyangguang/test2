package Leetcode;

public class A32isBalanced {
    public static void main(String[] args) {
        A32isBalanced test = new A32isBalanced();
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(1);
        a1.left = a2;
        a1.right = a3;
        a2.left = null;
        a2.right = null;
        a3.left = null;
        a3.right = null;
        boolean re = test.isBalanced(a1);
        System.out.println();
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isBalancedCore(root) == -1) {
            return false;
        }
        return true;
    }

    public int isBalancedCore(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = isBalancedCore(root.right);
        int right = isBalancedCore(root.left);
        if (left == -1 || right == -1 || left - right > 1 || right - left > 1) {
            return -1;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        return Math.max(left,right ) + 1;
    }
}
