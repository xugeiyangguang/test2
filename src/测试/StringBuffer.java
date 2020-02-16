package 测试;

public class StringBuffer {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("good");
        StringBuilder s2 = new StringBuilder("bad");
        exchange(s1, s2);
        System.out.println(s1);
        System.out.println(s2);

    }

    public static void exchange(StringBuilder s1, StringBuilder s2) {
        s1 = s2;
        s2 = new StringBuilder();
        s1 = s1.append("word");
        s2 = s2.append("word");

    }
}
