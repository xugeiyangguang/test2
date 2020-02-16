package ExperienceOfferTest;

public class StringToInt49 {
    int flag = 0; //1表示非法输入
    public static void main(String[] args) {
        StringToInt49 test = new StringToInt49();
        System.out.println(test.StrToInt("-2147483648"));
    }

    /*public static boolean flag;
    public static int StrToInt(String str) {
        flag = false;
        //判断输入是否合法
        if (str == null || str.trim().equals("")) {
            flag = true;
            return 0;
        }
        // symbol=0,说明该数为正数;symbol=1，该数为负数;start用来区分第一位是否为符号位
        int symbol = 0;
        int start = 0;
        char[] chars = str.trim().toCharArray();
        if (chars[0] == '+') {
            start = 1;
        } else if (chars[0] == '-') {
            start = 1;
            symbol = 1;
        }
        int result = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                flag = true;
                return 0;
            }
            int sum= result * 10 + (int) (chars[i] - '0');


            if((sum-(int) (chars[i] - '0'))/10!=result){
                flag=true;
                return 0;
            }

            result=result * 10 + (int) (chars[i] - '0');
            *//*
             * 本人认为java热门第一判断是否溢出是错误的，举个反例
             * 当输入为value=2147483648时，在计算机内部的表示应该是-2147483648
             * 显然value>Integer.MAX_VALUE是不成立的
             *//*
        }
        // 注意：java中-1的n次方不能用：(-1)^n .'^'异或运算
        // 注意，当value=-2147483648时，value=-value
        result = (int) Math.pow(-1, symbol) * result;
        return result;
    }*/
    public int  StrToInt(String str) {
        if (str==null||str.length()==0){
            flag = 1;
            return 0;
        }
        if (str.equals("0")){
            return 0;
        }
        int re= 0;
        String str2;
        if (str.charAt(0)=='+'||str.charAt(0)=='-'){
            str2 = str.substring(1,str.length());
        }else if (str.charAt(0)<'0'||str.charAt(0)>'9'){
            flag = 1;
            return 0;
        }else{
            str2 = str;
        }
        for (int i=0;i<str2.length();i++){
            if (str2.charAt(i)<'0'||str2.charAt(i)>'9'){
                flag = 1;
                return 0;
            }
            re += (str2.charAt(i)-48)*(int)Math.pow(10,str2.length()-1-i);
        }
        if (str.charAt(0)=='+'||str.charAt(0)=='-'){
            re = str.charAt(0)=='+'?re:-re;
        }
        return re;
    }
}
