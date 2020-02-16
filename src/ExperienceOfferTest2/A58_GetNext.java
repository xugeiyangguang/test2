package ExperienceOfferTest2;

public class A58_GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode temp;
        if (pNode.right != null) {
            temp = pNode.right;
            while (temp.left != null) {
                temp = temp.left;
            }

        } else {
            temp = pNode;
            while (temp.next != null && temp != temp.next.left) {
                temp = temp.next;
            }
            if (temp.next == null) {
                return null;
            }
            temp = temp.next;
        }
        return temp;
    }
}
