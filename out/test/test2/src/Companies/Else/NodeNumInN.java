package Companies.Else;

import java.util.ArrayDeque;

public class NodeNumInN {
    public static void main(String[] args) {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = null;
        a3.right = null;
        a3.left = null;
        a4.right = null;
        a4.left = null;
        NodeNumInN test = new NodeNumInN();
        test.getLevelNum(a1,5);

    }

    public void getLevelNum(TreeNode root,int target) {
        if (root == null) {
            System.out.println(0);
            return;
        }
        int curLevel = 1;
        int nextLevel = 0;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int level = 1;
        if (target == 1) {
            System.out.println(1);
            return;
        }
        while (deque.size() != 0) {
            while (curLevel != 0) {
                curLevel--;
                TreeNode temp = deque.poll();
                if (temp.left != null) {
                    deque.offer(temp.left);
                    nextLevel++;
                }
                if (temp.right != null) {
                    deque.offer(temp.right);
                    nextLevel++;
                }
            }
            if (level == target - 1) {
                System.out.println(nextLevel);
                return;
            }
            level++;
            curLevel = nextLevel;
            nextLevel = 0;
        }
        System.out.println(0);
        return;
    }
}
