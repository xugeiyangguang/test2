package 重要算法;



import Companies.Pdd.Tree;

import java.util.ArrayDeque;

public class 二叉树的遍历 {
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
        Pre(a1);
        System.out.println();
        System.out.print("递归先序遍历：");
        PPre(a1);
        In(a1);
        System.out.println();
        System.out.print("递归中序遍历：");
        InOrder(a1);
        Post(a1);
        System.out.println();
        System.out.print("递归后序遍历：");
        PostOrder(a1);
        System.out.println();
        System.out.print("递归层次遍历：");
        LevelTraverse(a1);
        //PostTraverse(a1);
    }

    //递归先序遍历
    public static void PPre(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        PPre(root.left);
        PPre(root.right);
    }

    //递归中序遍历
    public static void InOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        InOrder(root.left);
        System.out.print(root.val);
        InOrder(root.right);
    }

    //后续遍历
    public static void PostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.val);
    }

    /*先序遍历*/
    //先访问，后入栈
    public static void Pre(TreeNode root) {
        System.out.print("非递归先序：");
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        deque.push(root);
        while (deque.size() != 0) {
            while (root.left != null) {
                System.out.print(root.left.val);
                deque.push(root.left);
                root = deque.peek();
            }
            TreeNode temp = deque.pop();
            if (temp.right != null) {
                System.out.print(temp.right.val);
                deque.push(temp.right);
                root = temp.right;   //改变下一个节点
            }

        }
    }



    /*中序遍历*/
    //先入栈，后访问
    public static void In(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        System.out.println();
        System.out.print("中序:");
        while (deque.size() != 0) {
            while (root.left != null) {
                root = root.left;
                deque.push(root);
            }
            TreeNode p = deque.pop();
            System.out.print(p.val);
            if (p.right != null) {
                deque.push(p.right);
                root = p.right; //改变下一个节点
            }
        }
    }

    public static void Post(TreeNode root) {
        System.out.println();
        System.out.print("后序：");
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        TreeNode last = null;
        while (deque.size() != 0) {

            TreeNode top = deque.peek();
            //访问该节点的时候，
            //要么该节点的左右孩子为空
            //要么该节点的左孩子或者右孩子被访问过
            if ((top.left == null && top.right == null)
                    || (last != null) && (last == top.left || last == top.right)) {
                System.out.print(top.val);
                last = deque.pop();
            } else {
                //将右孩子先入栈，左孩子就先访问
                if (top.right != null) {
                    deque.push(top.right);
                }
                if (top.left != null) {
                    deque.push(top.left);
                }
            }
        }
    }

    //递归层次遍历
    public static void LevelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        int deep = Deep(root);
        for (int i = 1; i <= deep; i++) {
            LeverFunc(root, i);
        }
    }

    public static void LeverFunc(TreeNode root,int level) {
        if (root == null || level == 0) {
            return;
        }
        if (level == 1) {
            System.out.print(root.val);
        }
        LeverFunc(root.left, level - 1);
        LeverFunc(root.right, level - 1);
    }

    public static int Deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(Deep(root.left), Deep(root.right)) + 1;
    }

    /*public static void PostTraverse(TreeNode root) {
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
                System.out.println(temp.val);
                preNode = temp;
                root = stack.peek();
            }
        }
    }*/


}
