package Leetcode;

import java.util.ArrayDeque;

public class 二叉树的最大宽度662 {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        a1.left = a2;
        a1.right = null;
        a2.left = a3;
        a2.right = a4;
        a3.left = null;
        a3.right = null;
        a4.left = null;
        a4.right = null;
        int re = widthOfBinaryTree(a1);
        System.out.println();
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int cur = 1;
        int max = 1;
        while(deque.size()!=0){
            TreeNode tmp = deque.poll();
            cur--;
            if(tmp.left!=null){
                deque.offer(tmp.left);

            }else{
                deque.offer(new TreeNode(-99));

            }
            if(tmp.right!=null){
                deque.offer(tmp.right);

            }else{
                deque.offer(new TreeNode(-99));

            }
            if(cur==0){
                TreeNode tmp1 = deque.peek();
                while(deque.size()>0&&deque.getLast().val==-99){
                    deque.removeLast();
                }
                while(deque.size()>0&&deque.getFirst().val==-99){
                    deque.removeFirst();
                }
                cur = deque.size();
                max = Math.max(max,cur);
            }
        }
        return max;
    }
}
