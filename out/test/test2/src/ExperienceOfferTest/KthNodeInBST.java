package ExperienceOfferTest;

public class KthNodeInBST {
    public static void main(String[] args) {
        KthNodeInBST test = new KthNodeInBST();
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(6);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(6);
        TreeNode a6 = new TreeNode(7);
        TreeNode a7 = new TreeNode(8);
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
        System.out.println(test.KthNode(a1,2));
    }
    int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {

        if (pRoot==null){
            return null;
        }

        if (pRoot.left!=null){
             TreeNode temp = KthNode(pRoot.left,k);
             if (temp!=null){
                 return temp;
             }
        }
        count++;
        if (count == k){
            return pRoot;
        }
        if (pRoot.right!=null){
            TreeNode temp = KthNode(pRoot.right,k);
            if (temp!=null){
                return temp;
            }
        }
        return null;
    }
}
