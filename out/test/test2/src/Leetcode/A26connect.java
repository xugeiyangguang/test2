package Leetcode;

public class A26connect {
    public static void main(String[] args) {
        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode a1 = new TreeLinkNode(2);
        TreeLinkNode a2 = new TreeLinkNode(3);
        a.left = a1;
        a.right = a2;
        a1.left = null;
        a1.right = null;
        a2.left = null;
        a2.right = null;

        A26connect test = new A26connect();
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
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next == null) {
                root.right.next = null;
            } else {
                root.right.next = root.next.left;
            }

        }
        connectCore(root.left);
        connectCore(root.right);
    }
}
