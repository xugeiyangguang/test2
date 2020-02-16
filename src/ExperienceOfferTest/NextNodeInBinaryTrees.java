package ExperienceOfferTest;
/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class NextNodeInBinaryTrees {
    public static void main(String[] args) {
        NextNodeInBinaryTrees test = new NextNodeInBinaryTrees();

    }
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null){
            return null;
        }
        TreeLinkNode pNext = null;
        if (pNode.right != null){
            pNext = pNode.right;
            while (pNext.right!=null){
                pNext = pNext.left;
            }
        }else if(pNode.next != null){

            while (pNext.next.left != pNext){
                pNext = pNext.next;
            }
            pNext = pNode.next;
        }
        return pNext;
    }
}
