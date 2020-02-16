package ExperienceOfferTest;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class PrintTreesInZizag2 {
    public static void main(String[] args) {
        PrintTreesInZizag test = new PrintTreesInZizag();
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(6);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(6);
        TreeNode a6 = new TreeNode(7);
        TreeNode a7 = new TreeNode(8);
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
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();  //最后的返回结果
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();  //栈1
        stack1.push(pRoot);
        ArrayDeque<TreeNode> stack2 = new ArrayDeque<>();   //栈2
        while (stack1.size()!=0||stack2.size()!=0){
            ArrayList<Integer> levelNode = new ArrayList<>();
            if (stack1.size()!=0){   //栈1不为空
                while (stack1.size()!=0){
                    TreeNode temp = stack1.pollFirst();   //得到栈顶元素
                    levelNode.add(temp.val);
                    if (temp.left!=null){     //先将左节点入栈2
                        stack2.push(temp.left);
                    }
                    if (temp.right!=null){    //再将右节点入栈2
                        stack2.push(temp.right);
                    }
                }
            }else {
                while (stack2.size()!=0){     //栈2不为空
                    TreeNode temp = stack2.pollFirst();   //得到栈顶元素
                    levelNode.add(temp.val);
                    if (temp.right!=null){    //先将右节点入栈1
                        stack1.push(temp.right);
                    }
                    if (temp.left!=null){     //再将左节点入栈1
                        stack1.push(temp.left);
                    }
                }
            }
            result.add(levelNode);    //将各层节点值加入结果值中
        }
        return result;
    }
}
