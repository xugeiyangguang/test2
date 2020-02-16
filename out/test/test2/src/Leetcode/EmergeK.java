package Leetcode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class EmergeK {
    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        PriorityQueue<ListNode> dump = new PriorityQueue<>((a, b)->a.val-b.val);
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2)->o1.val - o2.val);
        ListNode head = new ListNode(0);
        ListNode last = head;
        for(int i=0;i<lists.size();i++){
            ListNode tmp = lists.get(i);
            if(tmp!=null){
                dump.offer(tmp);
                tmp = tmp.next;
            }

        }
        while(dump.size()!=0){
            ListNode tmp = dump.poll();
            last.next = tmp;
            last = last.next;
            tmp = tmp.next;
            if(tmp!=null){
                dump.offer(tmp);
            }
        }
        return head.next;
    }

}
