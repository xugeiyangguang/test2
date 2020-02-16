package HomeWork;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class LevelOrderBottom {
    public static void main(String[] args) {
        LevelOrderBottom test = new LevelOrderBottom();
        TreeNode a = new TreeNode(1);
        a.left = null;
        a.right = null;
        ArrayList<ArrayList<Integer>> re = test.levelOrderBottom(a);
        System.out.println();
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int curLevel = 1;
        int nextLevel = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (deque.size() != 0) {

            TreeNode tmp = deque.poll();
            if (tmp.left != null) {
                deque.offer(tmp.left);
                nextLevel++;
            }
            if (tmp.right != null) {
                deque.offer(tmp.right);
                nextLevel++;
            }
            list.add(tmp.val);
            curLevel--;

            if (curLevel == 0) {
                curLevel = nextLevel;
                nextLevel = 0;
                ArrayList<Integer> cur = new ArrayList<>(list);
                Collections.reverse(cur);
                list.clear();
                re.add(cur);
            }
        }
        Collections.reverse(re);
        return re;
    }
}
