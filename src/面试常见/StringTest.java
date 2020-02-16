package 面试常见;

public class StringTest {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        String c = new String("abc");
        String d = "abc";
   //     a.intern();
        System.out.println("a==b " + (a == b));
        System.out.println("c==b " + (c == b));
        System.out.println("a==d " + (a == d));
    }
}
