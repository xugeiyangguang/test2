package ExperienceOfferTest;

import java.util.*;   //引入包
public class ListIteratorExample {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        a.add("aaa");
        a.add("bbb");
        a.add("ccc");
        System.out.println("Before iterate : " + a);
        ListIterator<String> it = a.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next() + ", " + it.previousIndex() + ", " + it.nextIndex());
        }
        while (it.hasPrevious()) {
            System.out.print(it.previous() + " ");
        }
        System.out.println();
        it = a.listIterator(1);
        while (it.hasNext()) {
            String t = it.next();
            System.out.println(t);
            if ("ccc".equals(t)) {
                it.set("nnn");
            } else {
                it.add("kkk");
            }
        }
        System.out.println("After iterate : " + a);
    }
}