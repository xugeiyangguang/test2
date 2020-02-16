package ExperienceOfferTest;

public class MirrorOfBinaryTree {
    public static void main(String[] args){
        TreeNode a = new TreeNode(8);
        TreeNode b = new TreeNode(10);
        TreeNode c = new TreeNode(6);
        a.left = b;
        a.right= c;
        b.right = null;
        b.left = null;
        c.right = null;
        c.left = null;
        Mirror(a);
    }
    public static void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}

