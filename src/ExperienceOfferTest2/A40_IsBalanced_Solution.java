package ExperienceOfferTest2;

public class A40_IsBalanced_Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDept(root) == -1 ? false : true;
    }

    public int getDept(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDept(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDept(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
