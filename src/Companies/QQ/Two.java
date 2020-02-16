package Companies.QQ;

import java.util.Scanner;
import java.util.Stack;

public class Two {
    public static void main(String[] args) {
     //   Scanner scanner = new Scanner(System.in);
     //   String str = scanner.nextLine();
        String str = "HG[3|B[2|CA]]F";
        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        char[] arr = str.toCharArray();
        for (int i=arr.length-1;i>=0;i--){
            char c=arr[i];
            if ((!Character.isDigit(arr[i]))&&arr[i]!='|'){
                stack.push(String.valueOf(arr[i]));
            }
            else if (arr[i]=='|'){
                String num="";
                String s="";
                i=i-1;
                while (arr[i]!='['){
                    num=num+String.valueOf(arr[i]);
                    i--;
                }
                s=String.valueOf(stack.pop());
                while (!stack.peek().equals("]")){
                    s=s+String.valueOf(stack.pop());
                }
                stack.pop();
                String s2="";
                for (int j=0;j<Integer.parseInt(num);j++){

                    s2=s2+s;
                }
//                res.append(s2);
                stack.push(s2);
            }
        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
//        System.out.println("123");
        System.out.println(res.toString());
    }
}
