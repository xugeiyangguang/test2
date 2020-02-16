package Companies.Else;

import java.util.ArrayDeque;

public class Level{
    public static void main(String[] args){
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(1);
        a1.left = a2;
        a1.right= a3;
        a2.left=null;
        a2.right =null;
        a3.left=null;
        a3.right =null;
        show(a1);
    }
    public static void show(TreeNode root){
        if(root==null){
            return;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        TreeNode temp;
        while(deque.size()!=0){
            temp = deque.poll();
            System.out.print(temp.val);
            if(temp.left!=null){
                deque.offer(temp.left);

            }
            if(temp.right!=null){
                deque.offer(temp.right);
            }
        }
    }

}
/*class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int i){
        val = i;
    }
}*/
