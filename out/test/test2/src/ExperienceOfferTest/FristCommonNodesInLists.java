package ExperienceOfferTest;

public class FristCommonNodesInLists {
    public static void main(String[] args){
        FristCommonNodesInLists test = new FristCommonNodesInLists();
        int[] a = {1,2,3,6,7};
        int[] b = {4,5,6,7};
        ListNode a1 = ListNodeFunction.CreatLinkList(a);
        ListNode b1 =ListNodeFunction.CreatLinkList(b);
        System.out.println(test.FindFirstCommonNode(a1,b1));
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        /*计算链表的长度*/
        for (ListNode p=pHead1; p!=null; p=p.next){
            len1++;
        }
        for (ListNode p=pHead2; p!=null; p=p.next){
            len2++;
        }
        /*int pre = len1-len2>0?len1-len2:len2-len1;*/
        /*长的先走*/
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        if (len1>len2){
            for (int i = 0; i < len1-len2 ;i++ ){
                 p1 = p1.next;
            }
        }else if(len2>len1){
            for (int i = 0; i < len2-len1 ;i++ ){
                p2 = p2.next;
            }
        }
        while (p1!=null){
            if (p1.val==p2.val){
                return p1;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return null;
    }
}
