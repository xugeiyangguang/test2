package 重要算法;

public class 将二叉搜索树转换为双向链表 {
    static TreeNode last = null;
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(6);
        a1.left = a2;
        a1.right = a3;
        a2.left = null;
        a2.right = null;
        a3.left = null;
        a3.right = null;

        func(a1);

        while (last.left != null) {
            last = last.left;
        }
        while (last != null) {
            System.out.print(last.val);
            last = last.right;
        }
    }

    public static void func(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            func(root.left);
        }

        if (last != null) {
            last.right = root;
        }
        root.left = last;
        last = root;


        if (root.right != null) {
            func(root.right);
        }
    }
}
