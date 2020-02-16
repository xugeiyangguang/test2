package 面试常见;

public class 将字符串转换为数字 {
    public static void main(String[] args) {
        String s = "+123";
        int flag = 0;
        if (s.charAt(0) == '+') {
            flag = 1;
            s = s.substring(1);
        } else if (s.charAt(0) == '-') {
            flag = -1;
            s = s.substring(1);
        }
        int re = 0;
        for (int i = 0; i < s.length(); i++) {
            re = re * 10 + s.charAt(i) - '0';
        }
        if (flag == 1) {
            System.out.println("+" + re);
        } else if (flag == -1) {
            System.out.println("-" + re);
        } else {
            System.out.println(re);
        }
    }
}
