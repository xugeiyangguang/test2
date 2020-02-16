package ExperienceOfferTest2;

import java.util.ArrayList;

public class A25_二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        A25_二叉树中和为某一值的路径 test = new A25_二叉树中和为某一值的路径();
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(2);
        TreeNode a4 = new TreeNode(0);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = null;
        a3.left = null;
        a4.left = null;
        a3.right = null;
        a4.right = null;
        test.FindPath(a1, 6);
        System.out.println();

    }
/*
    //存放中间结果
    ArrayList<Integer> list = new ArrayList<>();
    //存放最终的结果
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        list.add(root.val);
        //左右都为空
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                result.add(new ArrayList<>(list));
            }
            return result;
        }
        if (root.left != null) {
            FindPath(root.left,target-root.val);
            list.remove(list.size()-1);
        }
        if (root.right != null) {
            FindPath(root.right, target - root.val);
            list.remove(list.size()-1);
        }

        return result;
    }*/

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        //深度遍历完了，要回退一个节点
        list.remove(list.size()-1);
        return listAll;
    }
}
