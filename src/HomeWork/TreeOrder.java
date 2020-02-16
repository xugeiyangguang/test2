package HomeWork;


import java.util.ArrayDeque;
import java.util.ArrayList;

public class TreeOrder {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        a1.left= a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = null;
        a3.right = null;
        a4.left = null;
        a4.right = null;
        a5.left = null;
        a5.right = null;
        TreeOrder test = new TreeOrder();
        System.out.print("递归前序遍历：");
        test.PreOrder(a1);
        System.out.println();
        System.out.print("递归中序遍历：");
        test.InOrder(a1);
        System.out.println();
        System.out.print("递归后序遍历：");
        test.PostOrder(a1);
        System.out.println();
        System.out.print("层次遍历：");
        test.LevelOrder(a1);
        System.out.println();
        test.PreTraverse(a1);
        System.out.println();
        test.InTraverse(a1);
        System.out.println();
        test.PostTraverse(a1);
        System.out.println();
    }
    //对节点进行操作
    public void doSomething(TreeNode node) {
        System.out.print(node.val);
    }
    //递归先序遍历
    public void PreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        doSomething(root);
        PreOrder(root.left);
        PreOrder(root.right);

    }

    //递归中序遍历
    public void InOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        InOrder(root.left);
        doSomething(root);
        InOrder(root.right);
    }

    //递归后序遍历
    public void PostOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        InOrder(root.left);
        InOrder(root.right);
        doSomething(root);
    }

    //层次遍历
    public void LevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.poll();
            doSomething(temp);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    //非递归先序遍历
    public void PreTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print("非递归先序遍历：");
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        doSomething(root);
        stack.push(root);

        while (stack.size() != 0) {
            while (root.left != null) {
                doSomething(root.left);
                stack.push(root.left);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            if (temp.right != null) {
                root = temp.right;
                doSomething(root);
                stack.push(root);
            }
        }
    }

    //非递归中序遍历
    public void InTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print("非递归中序遍历：");
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (stack.size() != 0) {
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            doSomething(temp);
            if (temp.right != null) {
                stack.push(temp.right);
                root = temp.right;
            }
        }
    }

    //非递归后序遍历
    public void PostTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print("非递归后序遍历：");
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode preNode = null;
        while (stack.size() != 0) {

            while (root.left != null && preNode != root.left && preNode != root.right) {

                stack.push(root.left);
                root = root.left;
            }
            TreeNode temp = stack.peek();
            if (temp.right != null && preNode != temp.right) {

                stack.push(root.right);
                root = root.right;
            } else {
                temp = stack.pop();
                doSomething(temp);
                preNode = temp;
                root = stack.peek();
            }
        }
    }

}
