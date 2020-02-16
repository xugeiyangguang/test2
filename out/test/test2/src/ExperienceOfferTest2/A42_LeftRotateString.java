package ExperienceOfferTest2;

public class A42_LeftRotateString {
    public static void main(String[] args) {
        String str = "abcXYZdef";
        A42_LeftRotateString test = new A42_LeftRotateString();
        String re = test.LeftRotateString(str, -21);
        return;
    }
    public String LeftRotateString(String str,int n) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        while (n < 0) {
            n = n + str.length();
        }
        n = n % str.length();
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[(i - n + str.length()) % str.length()] = str.charAt(i);
        }
        String re = String.valueOf(chars);
        return re;
    }
}
