package Leetcode;

import java.util.ArrayList;
//将题目分解成更小的子问题，（子节点，sum-父节点的值）
public class A28pathSum {
    public static void main(String[] args) {
        A28pathSum test = new A28pathSum();
        TreeNode a1 = new TreeNode(1);
        test.pathSum(a1,1);
        System.out.println();
    }

    ArrayList<ArrayList<Integer>> re = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<Integer> a = new ArrayList<>();
        pathSumCore(root,sum,a);
        return re;
    }

    public void pathSumCore(TreeNode root, int sum, ArrayList<Integer> a) {
        if (root == null) {
            return;
        }
        a.add(root.val);
        pathSumCore(root.left, sum - root.val, a);
        pathSumCore(root.right, sum - root.val, a);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                re.add(new ArrayList<>(a));   //链表的复制
            }
        }
        a.remove(a.size() - 1);
    }
}
