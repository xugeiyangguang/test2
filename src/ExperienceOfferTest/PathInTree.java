package ExperienceOfferTest;

import java.util.ArrayList;
import java.util.Stack;

public class PathInTree {
    static int count = 0;
    static int i = 0;
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    static Stack<TreeNode> s = new Stack<>();
    public static void main(String[] args){
        TreeNode a1 = new TreeNode(10);
        TreeNode a2 = new TreeNode(5);
        TreeNode a3 = new TreeNode(12);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = null;a3.right = null;
        a4.left = null;a4.right = null;
        a5.left = null;a5.right = null;
        TreeNode b = new TreeNode(8);
        TreeNode b1 = new TreeNode(9);
        b.left = null;b.right = b1;
        b1.left = null;b1.right = null;
        int target = 8;
        result = FindPath(b,target);
        if(result!=null){
            for (ArrayList<Integer> i:result
            ) {
                for (Integer j:i
                ) {
                    System.out.print(j+" ");

                }
                System.out.println();
            }
        }

    }
    /*二维数组的用法*/
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null || target <= 0){
            return null;
        }


        s.push(root);
        count+=root.val;
        //如果路径和为22，将栈中所有节点值赋给动态数组的一个位置
        if(count == target && root.left==null &&root.right ==null){
            ArrayList<Integer> a = new ArrayList<>();
            int i = 0;
            while(i<= s.size()-1){
                a.add(s.elementAt(i).val);
                i++;
            }
            result.add(a);
        }
        if(root.left != null){
            FindPath(root.left,target);
        }
        if(root.right != null){
            FindPath(root.right,target);
        }


        count -= s.peek().val;
        s.removeElementAt(s.size()-1);

        return result;
    }
}
