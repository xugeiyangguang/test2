package ExperienceOfferTest2;

public class A27_二叉树转为双向链表 {

    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(1);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = null;
        a3.left = null;
        a4.left = null;
        a3.right = null;
        a4.right = null;
        A27_二叉树转为双向链表 test = new A27_二叉树转为双向链表();
        TreeNode re = test.Convert(a1);
        System.out.println();

    }
    TreeNode lastNodeList = null;
    public  TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        /*TreeNode lastNodeList = null;*/
        ConveretNode(pRootOfTree);
        /*将头结点先指向尾节点*/

        TreeNode headOfList = lastNodeList;
        /*将头节点从最后往前面移动*/
        while (headOfList!=null&&headOfList.left!=null){
            headOfList = headOfList.left;
        }
        return headOfList;
    }

    /*lastNodeList只能改变它指向的对象的值，不能改变他指向的对象*/
    public  void ConveretNode(TreeNode pRootOfTree) {

        TreeNode currentNode = pRootOfTree;
        /*一直找到最右节点*/
        if (currentNode.left != null) {
            ConveretNode(currentNode.left);
        }
        /*将最右节点看成链表的尾节点*/
        currentNode.left = lastNodeList;
        /*将尾节点和当前中点节点链接*/
        if (lastNodeList != null) {
            lastNodeList.right = currentNode;
        }
        /*尾节点为当前节点*/
        lastNodeList = currentNode;
        /*对右子树进行同样的操作*/
        if (currentNode.right != null) {
            ConveretNode(currentNode.right);
        }
    }
}
