package ExperienceOfferTest2;

public class A63_KthNode {
    int count = 1;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) {

            return null;
        }
        TreeNode left = KthNode(pRoot.left, k);
        if (count++ == k) {
            return pRoot;
        }
        TreeNode right = KthNode(pRoot.right, k);
        if (left != null) {
            return left;
        } else {
            return right;
        }
    }
}
