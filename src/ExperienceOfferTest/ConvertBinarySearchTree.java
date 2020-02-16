package ExperienceOfferTest;
/*?????????????*/
public class ConvertBinarySearchTree {
    static TreeNode head = null;
    static TreeNode realHead = null;
    public static TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    private static void ConvertSub(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return;
        ConvertSub(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }
    /*static TreeNode lastNodeList = null;*/
    /*TreeNode lastNodeList = null;
    public  TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        *//*TreeNode lastNodeList = null;*//*
        ConveretNode(pRootOfTree);
        *//*将头结点先指向尾节点*//*

        TreeNode headOfList = lastNodeList;
        *//*将头节点从最后往前面移动*//*
        while (headOfList!=null&&headOfList.left!=null){
            headOfList = headOfList.left;
        }
        return headOfList;
    }

    *//*lastNodeList只能改变它指向的对象的值，不能改变他指向的对象*//*
    public  void ConveretNode(TreeNode pRootOfTree) {

        TreeNode currentNode = pRootOfTree;
        *//*一直找到最右节点*//*
        if (currentNode.left != null) {
            Convert(currentNode.left);
        }
        *//*将最右节点看成链表的尾节点*//*
        currentNode.left = lastNodeList;
        *//*将尾节点和当前中点节点链接*//*
        if (lastNodeList != null) {
            lastNodeList.right = currentNode;
        }
        *//*尾节点为当前节点*//*
        lastNodeList = currentNode;
        *//*对右子树进行同样的操作*//*
        if (currentNode.right != null) {
            Convert(currentNode.right);
        }
    }*/
    public static void main(String[] args){
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(8);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(9);
        TreeNode a5 = new TreeNode(2);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a5.left = a6;
        a5.right = a7;
        a3.left = null;a3.right = null;
        a4.left = null;a4.right = null;
        a6.left = null;a6.right = null;
        a7.left = null;a7.right = null;
        ConvertBinarySearchTree test = new ConvertBinarySearchTree();
        TreeNode r = test.Convert(a1);
        while(r!=null){
            System.out.print(r.val);
            r = r.right;
        }
       /* TreeNode r1 = test.Convert(a2);
        while(r1!=null){
            System.out.print(" "+r1.val);
            r1 = r1.right;
        }*/
    }
}
