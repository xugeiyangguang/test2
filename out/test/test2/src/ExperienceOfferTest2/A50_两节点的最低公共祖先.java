package ExperienceOfferTest2;

import java.util.ArrayDeque;

public class A50_两节点的最低公共祖先 {
    public static void main(String[] args) {
        A50_两节点的最低公共祖先 test = new A50_两节点的最低公共祖先();
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = null;
        a3.right = null;
        a4.left = null;
        a4.right = null;
        a5.left = null;
        a5.right = null;
        TreeNode re = test.LowestCommenParent(a1, a4, a5);
        System.out.println();
    }
    /*求两个链表的第一个公共节点*/
    public TreeNode LowestCommenParent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        ArrayDeque<TreeNode> deque1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> deque2 = new ArrayDeque<>();
        findNodePath(root, node1, deque1);
        findNodePath(root, node2, deque2);
        int size1 = deque1.size();
        int size2 = deque2.size();
        while (size1 > size2) {
            deque1.poll();
            size1--;
        }
        while (size2 > size1) {
            deque2.poll();
            size2--;
        }
        while (deque1.size() > 0 && (deque1.peek().val != deque2.peek().val)) {
            deque1.poll();
            deque2.poll();
        }
        if (deque1.size() == 0) {
            return null;
        }
        return deque1.peek();
    }

    /*找到某个节点的路径*/
    public boolean findNodePath(TreeNode root, TreeNode node1, ArrayDeque<TreeNode> deque) {
        deque.push(root);
        if (root.equals(node1)) {
            return true;
        }
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = findNodePath( root.left, node1, deque);
        }
        if (left == false && root.right != null) {
            right = findNodePath(root.right, node1, deque);
        }
        if (left == false && right == false) {
            deque.poll();
            return false;
        }
        return true;
    }
}
