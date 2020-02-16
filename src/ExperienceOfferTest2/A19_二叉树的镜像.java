package ExperienceOfferTest2;

//每个节点的左右节点都是交换的
public class A19_二叉树的镜像 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
