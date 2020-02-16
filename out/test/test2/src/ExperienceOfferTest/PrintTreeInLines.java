package ExperienceOfferTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PrintTreeInLines {
    public static void main(String[] args) {
        PrintTreeInLines test = new PrintTreeInLines();
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
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null){
            return new ArrayList<>();
        }
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque();
        int curLevelNode = 1;
        int nextLevelNode = 0;
        arrayDeque.add(pRoot);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (arrayDeque.size()!=0){
            ArrayList<Integer> levelNode = new ArrayList<>();

            while (curLevelNode!=0){
                curLevelNode--;
                TreeNode temp = arrayDeque.removeFirst();
                levelNode.add(temp.val);
                if (temp.left!=null){
                    nextLevelNode++;
                    arrayDeque.add(temp.left);
                }
                if (temp.right!=null){
                    nextLevelNode++;
                    arrayDeque.add(temp.right);
                }

            }
            result.add(levelNode);
            curLevelNode = nextLevelNode;
            nextLevelNode = 0;

        }
        return result;
    }
}
