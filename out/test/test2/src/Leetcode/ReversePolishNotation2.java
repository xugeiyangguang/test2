package Leetcode;

import java.util.ArrayDeque;
import java.util.regex.Pattern;

public class ReversePolishNotation2 {
    public static void main(String[] args) {
        ReversePolishNotation2 test = new ReversePolishNotation2();
        String[] tokens = {"3","-4","+"};
        System.out.println(test.evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0){
            return 0;
        }
        if (tokens.length == 1){
            return Integer.valueOf(tokens[0]);
        }
        ArrayDeque<String> deque = new ArrayDeque<>();
        int index = 0; //数组的下标
        int result = 0;    //最后的计算结果
        while (index != tokens.length){
            //如果是数字
            if (stringIsDigit(tokens[index]) == true){
                deque.push(tokens[index]);
            }else {    //如果遇到操作数
                int b = Integer.valueOf(deque.pop());   //弹出栈顶的第一个元素作为第二个操作数
                int a = Integer.valueOf(deque.pop());   //弹出栈顶的第二个元素作为第一个操作数
                if (tokens[index] .equals("+")){
                    result = a + b;
                }else if (tokens[index].equals("-")){
                    result = a - b;
                }else if (tokens[index].equals("*")){
                    result = a * b;
                }else if (tokens[index].equals("/")){
                    result = a / b;
                }else {
                    return 0;
                }
                deque.push(String.valueOf(result));
            }
            index++;
        }
        //如果表达式不合法，栈最后不为空
        if (deque.size() != 1 || stringIsDigit(deque.getFirst()) != true){
            return 0;
        }
        return result;
    }
    public boolean stringIsDigit(String str){
        Pattern pattern = Pattern.compile("^[-\\\\+]?[\\d]+$");
        return pattern.matcher(str).matches();
    }
}
