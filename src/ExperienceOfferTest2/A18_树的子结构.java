package ExperienceOfferTest2;

public class A18_树的子结构 {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(4);
        a1.left = a2;
        a1.right = a3;
        a2.left = null;
        a2.right = null;
        a3.left = null;
        a3.right = null;
        b1.left = b2;
        b1.right = b3;
        b2.left = null;
        b2.right = null;
        b3.left = null;
        b3.right = null;
        A18_树的子结构 test = new A18_树的子结构();
        boolean re = test.HasSubtree(a1, b1);
        System.out.println();

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result = false;
        if (root1.val == root2.val) {
            result = isCommon(root1, root2);
        }
        if (!result) {
            result = HasSubtree(root1.left, root2);
        }
        if (!result) {
            result = HasSubtree(root1.right, root2);
        }
        return result;
    }

    public boolean isCommon(TreeNode root1, TreeNode root2) {
        //递归的终止处
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return isCommon(root1.left, root2.left) && isCommon(root1.right, root2.right);
    }
}
