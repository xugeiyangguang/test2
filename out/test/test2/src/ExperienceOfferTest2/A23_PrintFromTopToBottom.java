package ExperienceOfferTest2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class A23_PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(root);
        while (arrayDeque.size() != 0) {
            TreeNode temp = arrayDeque.remove();
            arrayList.add(temp.val);
            if (temp.left != null) {
                arrayDeque.offer(temp.left);
            }
            if (temp.right != null) {
                arrayDeque.offer(temp.right);
            }
        }
        return arrayList;
    }
    public ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        TreeNode temp;
        ArrayList<Integer> result = new ArrayList<>();  //最后输出的顺序节点值，里面是值
        /*把双向链表当做队列*/
        LinkedList<TreeNode> q = new LinkedList<>(); //中间队列，存储的是节点
        q.add(root);
        while (q.size()!=0){  //队列不为空
            temp = q.removeFirst();
            result.add(temp.val);
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right != null){
                q.add(temp.right);
            }
        }
        return result;
    }
}
