package Companies.Else;

public class LongestPathInTree {
    public static void main(String[] args) {
        LongestPathInTree test = new LongestPathInTree();

        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(1);
        TreeNode a4 = new TreeNode(1);
        TreeNode a5 = new TreeNode(1);
        a1.left = a2;
        a1.right = null;
        a2.left = a3;
        a2.right = a5;
        a4.left = null;
        a4.right = null;
        a3.left = null;
        a3.right = null;
        a5.left = null;
        a5.right = null;
        System.out.println(test.maxPath(a1));
    }

    public int Path(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(Path(root.left), Path(root.right)) + 1;
    }

    public int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftPath = Path(root.left);
        int rightPath = Path(root.right);
        int notThroughRoot = Math.max(maxPath(root.left), maxPath(root.right));
        return Math.max(notThroughRoot, leftPath + rightPath );
    }
}
