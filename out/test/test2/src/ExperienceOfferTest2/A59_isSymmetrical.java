package ExperienceOfferTest2;

public class A59_isSymmetrical {
    public static void main(String[] args) {
    }
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetricalCore(pRoot.left, pRoot.right);
    }

    boolean isSymmetricalCore(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return isSymmetricalCore(root1.left, root2.right) && isSymmetricalCore(root2.left, root1.right);
        } else {
            return false;
        }
    }

}
