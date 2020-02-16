package Companies.Laohu;



import java.util.ArrayList;
import java.util.List;

public class One {
    public static void main(String[] args) {

        //用list存放所有链表的头节点
        ArrayList<ListNode> list = new ArrayList<>();
        //对list中的链表进行两两融合，list中最终剩下的一个链表就是最终的结果
        while (list.size() != 1) {
            list.add(func(list.get(0), list.get(1)));
        }

    }
    //对两个链表进行融合
    public static ListNode func(ListNode a, ListNode b) {
        ListNode p1 = a;
        ListNode p2 = b;
        ListNode head = new ListNode(-1);
        head.next = null;
        ListNode cur = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                ListNode tmp = p1.next;
                tmp.next = cur.next;
                cur.next = tmp;
                p1 = tmp;
                cur = cur.next;
            } else {
                ListNode tmp = p2.next;
                tmp.next = cur.next;
                cur.next = tmp;
                p2 = tmp;
                cur = cur.next;
            }
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        return head.next;
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int i){
        val = i;
    }
}