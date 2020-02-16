package ExperienceOfferTest2;

public class A49_StrToInt {
    public static void main(String[] args) {
        A49_StrToInt test = new A49_StrToInt();
        int re = test.StrToInt("-12345");
        System.out.println();
    }
    public int StrToInt(String str) {
        if (str == null || str.length() == 0||str.equals("0")) {
            return 0;
        }
        int sum = 0;
        //为负数吗？
        boolean flag = false;
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = true;
            i = 1;
        }
        if (str.charAt(0) == '+') {
            i = 1;
        }
        for (; i < str.length(); i++) {
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                sum = (sum * 10 + str.charAt(i) - '0');
            } else {
                return 0;
            }
        }
        if (flag == true) {
            sum = -sum;
        }
        return sum;
    }
}
