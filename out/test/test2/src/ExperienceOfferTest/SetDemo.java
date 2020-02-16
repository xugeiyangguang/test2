package ExperienceOfferTest;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @description 几个set的比较
 *    HashSet：哈希表是通过使用称为散列法的机制来存储信息的，元素并没有以某种特定顺序来存放；
 *    LinkedHashSet：以元素插入的顺序来维护集合的链接表，允许以插入的顺序在集合中迭代；
 *    TreeSet：提供一个使用树结构存储Set接口的实现，对象以升序顺序存储，访问和遍历的时间很快。
 * @author Zhou-Jingxian
 *
 */
public class SetDemo {

    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("B");
        hs.add("使用value对hashMap排序");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");
        System.out.println("HashSet 顺序:\n"+hs);

        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        lhs.add("B");
        lhs.add("使用value对hashMap排序");
        lhs.add("D");
        lhs.add("E");
        lhs.add("C");
        lhs.add("F");
        System.out.println("LinkedHashSet 顺序:\n"+lhs);

        TreeSet<String> ts = new TreeSet<String>();
        ts.add("B");
        ts.add("使用value对hashMap排序");
        ts.add("D");
        ts.add("E");
        ts.add("C");
        ts.add("F");
        System.out.println("TreeSet 顺序:\n"+ts);
    }
}