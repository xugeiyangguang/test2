package Leetcode;

public class A27connect {
    public static void main(String[] args) {
        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode a1 = new TreeLinkNode(2);
        TreeLinkNode a2 = new TreeLinkNode(3);
        TreeLinkNode a3 = new TreeLinkNode(4);
        TreeLinkNode a4 = new TreeLinkNode(5);
        a.left = a1;
        a.right = a2;
        a1.left = a3;
        a1.right = null;
        a2.left = null;
        a2.right = a4;
        a4.left = null;
        a4.right = null;
        a3.left = null;
        a3.right = null;

        A27connect test = new A27connect();
        test.connect(a);
        System.out.println();
    }
    public void connect(TreeLinkNode root) {
        if (root == null){
            return;
        }
        root.next = null;
        connectCore(root);
    }
    public void connectCore(TreeLinkNode root){
        if (root == null) {
            return;
        }
        if (root.left != null) {//如果节点的左子节点不为空,处理右子节点
            if (root.right != null) {   //如果有右子节点
                root.left.next = root.right;
            } else {
                root.left.next = nextNode(root);
            }
        }
        if (root.right != null) {
            root.right.next = nextNode(root);
        }
        connectCore(root.left);
        connectCore(root.right);
    }

    public TreeLinkNode nextNode(TreeLinkNode node) {
        while (node.next != null) {
            node = node.next;
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
        }
        return null;
    }
}
