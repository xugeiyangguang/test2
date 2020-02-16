package Leetcode;

public class A31isSameTree {
    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode q1 = new TreeNode(1);
        TreeNode q2 = new TreeNode(2);
        TreeNode q3 = new TreeNode(4);
        p1.left = p2;
        p1.right = p3;
        p2.left = null;
        p2.right = null;
        p3.left = null;
        p3.right = null;
        q1.left = q2;
        q1.right = q3;
        q2.left = null;
        q2.right = null;
        q3.left = null;
        q3.right = null;
        A31isSameTree test = new A31isSameTree();
        boolean re = test.isSameTree(null, q2);
        System.out.println();
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}
