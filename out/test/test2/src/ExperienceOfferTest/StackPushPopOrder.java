package ExperienceOfferTest;

import java.util.Stack;

public class StackPushPopOrder {
    public static void main(String[] args){

        int[] pushA = {};
        int[] popA = {};
        StackPushPopOrder test = new StackPushPopOrder();
        System.out.print(test.IsPopOrder(pushA,popA));
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (popA == null || popA.length == 0) {   /*为空序列*/
            return false;
        }
        Stack<Integer> help = new Stack<>();
        int i = 0;  //pushA
        int j = 0;  //popA
        while (j < popA.length) {

            if(help.size() == 0 || help.peek() != popA[j] ){  //如果出现序列和栈顶不同

                if (i > pushA.length - 1) {  //当下标超出范围，应该不会有压栈行为
                    return false;
                }
                help.push(pushA[i]);
                i++;
            }else{   //如果出栈序列和栈顶相同，直接出栈
                j++;
                help.pop();
            }
        }
        return true;
    }
}

