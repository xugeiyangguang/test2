package ExperienceOfferTest;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        BalancedBinaryTree test =new BalancedBinaryTree();

        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(8);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(9);
        TreeNode a5 = new TreeNode(2);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a5.left = a6;
        a5.right = a7;
        a3.left = null;a3.right = null;
        a4.left = null;a4.right = null;
        a6.left = null;a6.right = null;
        a7.left = null;a7.right = null;
        System.out.println(test.IsBalanced_Solution(a1));
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root)!=-1;

    }
    public int getDepth(TreeNode root){
        if (root == null){return 0;}
        int left = getDepth(root.left);
        if (left==-1){return -1;}
        int right = getDepth(root.right);
        if (right==-1){return -1;}
        return Math.abs(left-right)>1?-1:Math.max(left,right)+1;
    }
}
