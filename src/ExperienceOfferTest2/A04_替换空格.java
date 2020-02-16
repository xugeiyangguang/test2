package ExperienceOfferTest2;

public class A04_替换空格 {
    public static void main(String[] args) {
        A04_替换空格 test = new A04_替换空格();
        StringBuffer str = new StringBuffer("   ");
        String re = test.replaceSpace(str);
        System.out.println();
    }
    public  String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int blankCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                blankCount++;
            }
        }
        int newLen = blankCount * 2 + str.length();
        int len = str.length();
        str.setLength(newLen);
        int j = 0;
        for (int i = 0; i < newLen; i++) {

            if (str.charAt(len - j - 1) != ' ') {
                str.setCharAt(newLen - i - 1,str.charAt(len - j - 1));
            } else {
                str.setCharAt(newLen - i - 1,'0');
                i++;
                str.setCharAt(newLen - i - 1,'2');
                i++;
                str.setCharAt(newLen - i - 1,'%');
            }
            j++;
        }
        return str.toString();
    }
}
