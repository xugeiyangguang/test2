package HomeWork;

public class IInterleave {
    public static void main(String[] args) {
        IInterleave test = new IInterleave();
        boolean re = test.isInterleave("024", "1356", "0123456");
        System.out.println();
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0 || s1.length() + s2.length() != s3.length()) {
            return true;
        }
        int index = 0;
        int i = 0;
        int j = 0;
        for (; i < s1.length(); i++) {
            for (; j < s2.length(); j++) {
                while (s1.charAt(i) == s3.charAt(index)) {
                    i++;
                    index++;
                }
                while (s2.charAt(j) == s3.charAt(index)) {
                    j++;
                    index++;
                }
            }
        }
        if (i == s1.length() && j == s2.length() && index == s3.length()) {
            return true;
        }
        return false;
    }

    /*public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0 || s1.length() + s2.length() != s3.length()) {

            return true;
        }
        boolean r1 = false;
        boolean r2 = false;
        if (s1.length() != 0 && s1.charAt(0) == s3.charAt(0)) {
            r1 = isInterleave(s1.substring(1), s2, s3.substring(1));
        }
        if (s2.length() != 0 && r1 == false && s2.charAt(0) == s3.charAt(0)) {
            r2 = isInterleave(s1, s2.substring(1), s3.substring(1));
        }
        return r1 || r2;
    }*/
}
