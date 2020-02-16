package HomeWork;

import java.util.TreeMap;

public class ArrayQueue {
    private int[] queue;

    private int size;  //队列的容量
    private int length = 0;  //队列的长度
    private int front = 0;   //指向头元素
    private int back = 0;   //back元素指向尾元素的后一个位置
    //构造函数
    public  ArrayQueue(){
        queue = new int[100]; //默认队列大小为100
        size = 100;
    }
    public ArrayQueue(int size){
        int[] queue = new int[size];  //用户可以指定大小
        this.size = size;
    }
    //取得对头元素
    public int getFirst(){
        return queue[front];
    }
    //取得队尾元素
    public int getLast(){

        return queue[back-1];
    }
    //取得队列的大小
    public int getSize(){
        return length;
    }
    //加入与元素,加入队尾
    public void add(int a){
        //队列满
        if (front == back + 1){
            return;
        }
        queue[back] = a;
        back++;
        length++;
    }
    //删除元素，删除队头
    public void remove(){
        if (length == 0){
            return;
        }
        front++;
        length--;
    }
    //删除并且返回队头元素
    public int poll(){
        //如果队列为空，则报错
        if (length == 0){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        length--;
        return queue[front++];
    }
    //显示队列的所有元素
    public void show(){
        for (int i = front;i != back; i++){
            if (i == size-1){
                i = 0;
            }
            System.out.print(queue[i]);
        }
    }

    public static void main(String[] args) {
        ArrayQueue test = new ArrayQueue();
        test.add(3);
        test.add(2);
        test.add(1);
        System.out.print("队列的所有元素为：");
        test.show();
        System.out.print("\n队首元素为:" + test.getFirst());
        System.out.print("\n队尾元素为:" + test.getLast());
        test.remove();
        System.out.print("\n删除队首后的结果为:");
        test.show();
    }
}
