package Companies.Baidu;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        TreeNode r = new TreeNode(n);
        TreeNode root = func(r, k);
        int re = func2(root);
        System.out.println(re);
    }

    public static TreeNode func(TreeNode node, int k) {
        if (node.val <= 2) {
            node.left = null;
            node.right = null;
            return node;
        }
        int a = 0;
        int b = 0;
        for (int i = 1; i < node.val; i++) {
            if (node.val - i - i == k) {
                a = i;
                b = node.val - i;
            }
        }
        if (a == b) {
            node.left = null;
            node.right = null;
            return node;
        }
        node.left = new TreeNode(a);
        node.right = new TreeNode(b);
        func(node.left, k);
        func(node.right, k);
        return node;
    }

    public static int func2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return func2(root.left) + func2(root.right);
    }
}


