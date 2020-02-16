package Companies.Else;

public class Main{
    public static void main(String[] args){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        a3.next = null;
        ListNode re = func(a1,3);
        if (re == null) {
            System.out.println(-1);
        } else {
            System.out.println(re.val);
        }


    }
    public static ListNode func(ListNode node,int k){
        ListNode cur = node;
        while(cur!=null&&k>1){
            cur = cur.next;
            k--;
        }
        if(cur==null){
            return null;
        }
        ListNode temp = node;
        while(cur.next!=null){
            cur = cur.next;
            temp = temp.next;
        }
        return temp;
    }
}

