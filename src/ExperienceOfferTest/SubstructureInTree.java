package ExperienceOfferTest;

public class SubstructureInTree {
    public static void main(String[] args){
        /*TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(8);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(9);
        TreeNode a5 = new TreeNode(2);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(7);
        TreeNode b1 = new TreeNode(8);
        TreeNode b2 = new TreeNode(9);
        TreeNode b3 = new TreeNode(2);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a5.left = a6;
        a5.right = a7;
        b1.left = b2;
        b1.right = b3;
        a3.left = null;a3.right = null;
        a4.left = null;a4.right = null;
        a6.left = null;a6.right = null;
        a7.left = null;a7.right = null;*/
        TreeNode b2 = new TreeNode(8);
        TreeNode b3 = new TreeNode(8);
        b2.left = null;b2.right = null;
        b3.left = null;b3.right = null;
        System.out.println(HasSubtree(null,null));
    }
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {


        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                result = DoseTree1HaveTree2(root1,root2);
            }
            if(!result) result = HasSubtree(root1.left,root2);
            if(!result) result = HasSubtree(root1.right,root2);
        }

        return result;
    }
    public static boolean DoseTree1HaveTree2(TreeNode root1,TreeNode root2){
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return (DoseTree1HaveTree2(root1.left,root2.left)&&DoseTree1HaveTree2(root1.right,root2.right));
    }
}
