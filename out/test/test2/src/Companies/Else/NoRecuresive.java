package Companies.Else;

import java.util.ArrayDeque;

public class NoRecuresive {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(2);
        TreeNode a4 = new TreeNode(0);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = null;
        a3.left = null;
        a4.left = null;
        a3.right = null;
        a4.right = null;
        System.out.print("前序：");
        PreOrder(a1);
        System.out.println();
        System.out.print("中序：");
        InOrder(a1);
        System.out.println();
        System.out.print("后序：");

        PostOrder(a1);
    }
//    前序遍历
    public static void PreOrder(TreeNode root){
        if (root == null) {
            return;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        System.out.print(root.val);
        while (deque.size()!=0){
            while (root.left!=null){
                System.out.print(root.left.val);
                deque.push(root.left);
                root = root.left;
            }
            TreeNode tmp = deque.pop();
            if (tmp.right!=null){
                deque.add(tmp.right);
                System.out.print(tmp.right.val);
                root = tmp.right;    //修改新的当前节点
            }
        }

    }
    /*中序遍历*/
    public static void InOrder(TreeNode root){
        if (root == null) {
            return;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (deque.size()!=0){
            while (root.left != null) {
                deque.push(root.left);
                root = root.left;
            }
            TreeNode tmp = deque.pop();
            System.out.print(tmp.val);
            if ((tmp.right != null)) {
                deque.push(tmp.right);
                root = tmp.right;
            }
        }
    }
    /*后续遍历*/
    public static void PostOrder(TreeNode root){
        if (root == null) {
            return;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        TreeNode last = null;
        while (deque.size() != 0) {
            if ((deque.peek().left == null && deque.peek().right == null)
                    || (last != null) && (last == deque.peek().right || last == deque.peek().left)) {
                System.out.print(deque.peek().val);
                last = deque.pop();
            } else {
                TreeNode a = deque.peek();
                if (a.right != null) {
                    deque.push(a.right);
                }
                if (a.left != null) {
                    deque.push(a.left);
                }
            }
        }
    }
}
