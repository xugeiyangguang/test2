package ExperienceOfferTest;

public class ListNodeFunction {
    public ListNode head;
    /*打印链表内容*/
    public void PrintLinkList(){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val);
            temp = temp.next;
        }
    }
    /*使用数组创建链表*/
    /*静态方法不需要使用类的属性，自己单独完成一个功能*/
    public  static ListNode CreatLinkList(int[] array){
        if(array == null && array.length == 0){
            System.out.println("No element!");
        }
        ListNode L = new ListNode(array[0]);
        ListNode last = L;
        for(int i=1; i<array.length; i++){
            ListNode newNode = new ListNode(array[i]);
            last.next = newNode;
            last = last.next;
            if(i == array.length-1){
                last.next = null;
            }
        }
        return L;
    }
    /*在末尾增加节点*/
    public  ListNode addNode(int a){
        ListNode node = new ListNode(a);
        ListNode temp = this.head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
        return  this.head;
    }
    //    删除指定值的节点
//    index是从零开始的下标
    public  ListNode deleteNode(int index){
        if(index < 0 || index > this.ListLen()){
            System.out.println("输入不合法！");
            return null;
        }
        ListNode temp = head;
        if(index == 0){
            head = head.next;
            return head;
        }

        int count = 0;
        while (count < index-1){
            temp = temp.next;
            count++;
        }
        temp.next = temp.next.next;
        return head;
    }
    /*在指定位置插入节点*/
    public  ListNode insertNode(int index,int a){
        if(index < 0 || index > this.ListLen()){
            System.out.println("输入不合法！");
            return null;
        }
        ListNode nodeA = new ListNode(a);
        ListNode temp = head;
        int count = 0;
        if(index == 0){
            nodeA.next = head;
            head = nodeA;
            return head;
        }
        while (count < index-1){
            count++;
            temp = temp.next;   //temp是插入位置的前一个节点
        }
        nodeA.next = temp.next;
        temp.next = nodeA;
        return head;
    }
    /*获取链表的长度*/
    public  int ListLen(){
        int len = 0;
        ListNode temp = head;
        while (temp!=null){
            len ++;
            temp = temp.next;
        }
        return len;
    }
    public static void main(String[] args){
        ListNodeFunction test = new ListNodeFunction();
        int[] array = {2,3,4,5,6,7};
        test.head = CreatLinkList(array);
        System.out.print("\n原始序列为：");
        test.PrintLinkList();
        System.out.print("\n加入一个节点：");
        test.addNode(1);
        test.PrintLinkList();
        System.out.print("\n删除第一个节点：");
        test.deleteNode(0);
        test.PrintLinkList();
        System.out.print("\n在指定位置插入一个节点：");
        test.insertNode(0,9);
        test.PrintLinkList();
        System.out.print("\n链表的长度为：");
        System.out.print(test.ListLen());

    }
}
