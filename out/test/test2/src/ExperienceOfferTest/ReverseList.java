package ExperienceOfferTest;

public class ReverseList {
    public static void main(String[] args){
        ListNodeFunction test =new ListNodeFunction();
        int[] array = {2,3,4,5,6,7};
        test.head = ListNodeFunction.CreatLinkList(array);
        System.out.print("原始序列为：");
        test.PrintLinkList();
        System.out.print("\n逆转后的链表为：");
        test.head = ReverseList(test.head);
        test.PrintLinkList();

        /*ListNode L0 = new ListNode(2);
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(6);
        ListNode l5 = new ListNode(7);
        L0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;


        L0 = ListNodeFunction.CreatLinkList(array);*/

    }
    public static ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode newHead = null;
        ListNode pre;
        while (head!=null){
            pre = head;
            head = pre.next;
            pre.next = newHead;
            newHead = pre;
        }
        return newHead;
    }
public static void PrintLinkList(ListNode head){
        while(head!=null){
            System.out.print(head.val);
            head = head.next;
        }
    }
    public static ListNode CreatLinkList(int[] array){
        if(array == null && array.length == 0){
            System.out.println("No element!");
        }
        ListNode L = new ListNode(array[0]);
        ListNode last = L;
        for(int i=1; i<array.length; i++){
            ListNode newNode = new ListNode(array[i]);
            last.next = newNode;
            if(i == array.length-1){
                last.next = null;
            }else{
                last = last.next;
            }
        }
        return L;
    }


}
