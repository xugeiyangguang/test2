package Companies.Else;

public class HasCircle {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;

        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = null;
        System.out.println(fun(a1));

    }
    public static boolean fun(ListNode head){
        ListNode one = head;
        ListNode two = head.next;
        while (one != two && two != null) {
            one = one.next;
            two = two.next;
            if (two == null) {
                return false;
            }
            two = two.next;
        }
        if (two == null) {
            return false;
        }
        return true;
    }
}
