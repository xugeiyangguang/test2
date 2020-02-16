package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class inorderTraversal {
    public static void main(String[] args) {
        inorderTraversal test = new inorderTraversal();
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        a1.left = a2;
        a1.right = a3;
        a2.left = null;
        a2.right = null;
        a3.left = a4;
        a3.right = a5;
        a4.left = null;
        a4.right = null;
        a5.left = null;
        a5.right = null;
        test.inorderTraversal(a1);
    }
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> re = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (deque.size() != 0) {
            while (root.left != null) {
                deque.push(root.left);
                root = root.left;
            }
            TreeNode temp = deque.pop();
            re.add(temp.val);
            if (temp.right != null) {
                deque.push(temp.right);
                root = temp.right;
            }
        }
        return re;
    }

}
