package ExperienceOfferTest2;



import java.util.ArrayDeque;
import java.util.ArrayList;

/*使用栈或者递归*/
public class A05_倒序打印链表的节点 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        ArrayDeque<ListNode> listNodes = new ArrayDeque<>();
        ListNode temp = listNode;
        while (temp != null) {
            listNodes.push(temp);
            temp = temp.next;
        }
        ArrayList<Integer> re = new ArrayList<>();
        while (listNodes.size() != 0) {
            re.add(listNodes.poll().val);
        }
        return re;
    }
}
