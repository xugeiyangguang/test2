package ExperienceOfferTest2;

public class A53_match {
    public static void main(String[] args) {
        A53_match test = new A53_match();
        char[] str = {};
        char[] pattern = {'.', '*'};
        boolean re = test.match(str, pattern);
        System.out.println();
    }
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern);
    }
    public boolean matchCore(char[] str, char[] pattern) {
        if (str.length == 0 && pattern.length == 0) {
            return true;
        }
        if (str.length != 0 && pattern.length == 0) {
            return false;
        }
        return false;

    }
}
