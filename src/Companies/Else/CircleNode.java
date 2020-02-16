package Companies.Else;

public class CircleNode {
    public static void main(String[] args){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a3;
        ListNode re = Select(a1);
        System.out.println(re.val);
    }
    public static ListNode Select(ListNode head){
        ListNode one = head;
        ListNode two = head.next;
        while(one!=two){
            one = one.next;
            two = two.next.next;
        }
        int len = 1;
        two = two.next;
        while(one!=two){
            two = two.next;
            len++;
        }
        one = head;
        two = head;
        while(len>0){
            two = two.next;
            len--;
        }
        while(one!=two){
            one = one.next;
            two = two.next;
        }
        return one;
    }
}
