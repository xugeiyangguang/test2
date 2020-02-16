package HomeWork;

public class BuildTreeByInPos {
    public static void main(String[] args) {
        BuildTreeByInPos test = new BuildTreeByInPos();
        int[] inorder = {2, 1, 3, 4, 5};
        int[] postorder = {2, 4, 5, 3, 1};
        TreeNode re = test.buildTree(inorder, postorder);
        System.out.println();
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return buildTreeNode(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTreeNode(int[] inorder, int inStart, int inEnd, int[] posrorder, int posStart, int posEnd) {
        if (inEnd < inStart || posEnd < posStart) {
            return null;
        }
        int index = getIndex(inorder, posrorder[posEnd]);
        TreeNode tmp = new TreeNode(inorder[index]);
        tmp.left = buildTreeNode(inorder, inStart, index - 1, posrorder, posStart, posStart + index - inStart - 1);
        tmp.right = buildTreeNode(inorder, index + 1, inEnd, posrorder, posStart + index - inStart, posEnd - 1);
        return tmp;
    }

    public int getIndex(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
