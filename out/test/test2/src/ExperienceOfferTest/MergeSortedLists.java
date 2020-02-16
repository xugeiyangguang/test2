package ExperienceOfferTest;

public class MergeSortedLists {
    public static void main(String[] args){
        ListNodeFunction a = new ListNodeFunction();
        int[] array1 = {1,3,5,7};
        int[] array2 = {2,4,6,8};
        ListNode L1 = a.CreatLinkList(array1);
        ListNode L2 = a.CreatLinkList(array2);
        a.head = Merge(L1,L2);
        a.PrintLinkList();

    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null) {
            return list1;
        }

        ListNode newHead;

        if(list1.val < list2.val){
            newHead = list1;
            newHead.next = Merge(list1.next,list2);
        }else {
            newHead = list2;
            newHead.next = Merge(list1,list2.next);
        }
        return newHead;
//        System.out.println("mmm");

    }

}
