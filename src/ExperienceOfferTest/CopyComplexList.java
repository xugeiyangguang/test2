package ExperienceOfferTest;

public class CopyComplexList {
    public static void main(String[] args){
        RandomListNode a1 = new RandomListNode(1);
        RandomListNode a2 = new RandomListNode(2);
        RandomListNode a3 = new RandomListNode(3);
        RandomListNode a4 = new RandomListNode(4);
        RandomListNode a5 = new RandomListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = null;
        a1.random = a3;
        a2.random = a5;
        a4.random = a2;
        RandomListNode r = Clone(a1);
        while (r!=null){
            System.out.print(r.label);
            r = r.next;
        }

    }
    /*复制每个节点，并将复制节点链接在他后面*/
    public static void CloneNodes(RandomListNode pHead){
        RandomListNode currentNode = pHead;
        while (currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            cloneNode.next = currentNode.next;
            currentNode.next = cloneNode;
            currentNode = cloneNode.next;
            cloneNode.random = null;
        }
    }
    /*将复制后的每个节点的随机指针复制*/
    public static void ConnectSiblingNodes(RandomListNode pHead){
        RandomListNode currentNode = pHead;
        while (currentNode != null){
            if(currentNode.random != null){
                currentNode.next.random = currentNode.random.next;
            }
            currentNode = currentNode.next.next;
        }
    }
    /*根据节点所在的奇偶数位置，将链表分成两个*/
    public static RandomListNode ReconnectNodes(RandomListNode pHead){
        if(pHead==null){
            return null;
        }
        RandomListNode currentNode = pHead;
        RandomListNode pCloneHead = pHead.next; //复制链表的头结点
        RandomListNode cloneNode = pCloneHead;
        while (cloneNode.next!=null){
            currentNode.next =currentNode.next.next;

            currentNode = currentNode.next;
            cloneNode.next = cloneNode.next.next;
            cloneNode = cloneNode.next;
        }
        currentNode.next = null;
        return pCloneHead;
    }
    public static RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode t;
        CloneNodes(pHead);
        for (t=pHead;t!=null;t=t.next){
            System.out.print(t.label);
        }
        System.out.println();

        ConnectSiblingNodes(pHead);
        for (t=pHead;t!=null;t=t.next){
            System.out.print(t.label);
        }
        System.out.println();

        return ReconnectNodes(pHead);

    }
}
