package ExperienceOfferTest2;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class A60_Print {
    public static void main(String[] args) {
        A60_Print test = new A60_Print();
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(6);
        TreeNode a3 = new TreeNode(6);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(7);
        TreeNode a6 = new TreeNode(7);
        TreeNode a7 = new TreeNode(5);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;
        a5.left = null;a5.right = null;
        a4.left = null;a4.right = null;
        a6.left = null;a6.right = null;
        a7.left = null;a7.right = null;
        ArrayList<ArrayList<Integer>> re = test.Print(a1);
        for (ArrayList<Integer> a:re
        ) {
            for (Integer i:a
            ) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();

        deque.add(pRoot);
        int curCount = 1;
        int nextCount = 0;
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
            re.add(temp);
        }
        return re;
    }
}
