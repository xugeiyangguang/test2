package ExperienceOfferTest2;

public class A06重建二叉树 {
    public static void main(String[] args) {
        A06重建二叉树 test = new A06重建二叉树();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode re = test.reConstructBinaryTree(null, null);
        System.out.println();
    }
    public  TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        return reConstructBinaryTreeCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTreeCore(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {

        int i = 0;
        //i为中序遍历中头结点的值
        for (; i < in.length; i++) {
            if (in[i] == pre[preStart]) {
                break;
            }
        }
        int leftLen = i - inStart;
        TreeNode root = new TreeNode(pre[preStart]);
        //有左子树
        if (leftLen > 0) {
            root.left = reConstructBinaryTreeCore(pre, preStart + 1, preStart + leftLen, in, inStart, i - 1);
        }else{
            root.left = null;
        }
        //有右子树
        if (inEnd - i > 0) {
            root.right = reConstructBinaryTreeCore(pre, preStart + leftLen + 1, preEnd, in, i + 1, inEnd);
        } else {
            root.right = null;
        }
        return root;

    }
}
