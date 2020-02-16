package ExperienceOfferTest2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class A61_Print {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();

        deque.add(pRoot);
        int curCount = 1;
        int nextCount = 0;
        int reverse = -1; // 为1的时候要翻转
        while (deque.size() != 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            while (curCount != 0) {
                TreeNode top = deque.poll();
                curCount--;
                temp.add(top.val);
                if (top.left != null) {
                    deque.add(top.left);
                    nextCount++;
                }
                if (top.right != null) {
                    deque.add(top.right);
                    nextCount++;
                }
            }
            curCount = nextCount;
            nextCount = 0;
            if (reverse == 1) {
                Collections.reverse(temp);
            }
            re.add(temp);
            reverse = -reverse;

        }
        return re;
    }
}
