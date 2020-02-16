package ExperienceOfferTest;

public class SysmmetricalBinaryTree {
    public static void main(String[] args) {
        SysmmetricalBinaryTree test = new SysmmetricalBinaryTree();
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(6);
        TreeNode a3 = new TreeNode(6);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(7);
        TreeNode a6 = new TreeNode(7);
        TreeNode a7 = new TreeNode(5);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;
        a5.left = null;a5.right = null;
        a4.left = null;a4.right = null;
        a6.left = null;a6.right = null;
        a7.left = null;a7.right = null;
        System.out.println(test.isSymmetrical(a1));
    }
    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSysmmetrical(pRoot,pRoot);
    }
    boolean isSysmmetrical(TreeNode pRoot1,TreeNode pRoot2){
        if (pRoot1==null&&pRoot2==null){
            return true;
        }
        if (pRoot1==null||pRoot2==null){
            return false;
        }
        if (pRoot1.val!=pRoot2.val){
            return false;
        }
        return isSysmmetrical(pRoot1.left,pRoot2.right)&&
                isSysmmetrical(pRoot1.right,pRoot2.left);
    }
}
