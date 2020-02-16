package ExperienceOfferTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapTest {

    public static void main(String[] args) {

        //HashMap
        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("4", "d");
        hashMap.put("3", "c");
        hashMap.put("2", "b");
        hashMap.put("1", "a");

        Iterator<String> iteratorHashMap = hashMap.keySet().iterator();

        System.out.println("HashMap-->");

        while (iteratorHashMap.hasNext()){

            Object key1 = iteratorHashMap.next();
            System.out.println(key1 + "--" + hashMap.get(key1));
        }

        //LinkedHashMap
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("4", "d");
        linkedHashMap.put("3", "c");
        linkedHashMap.put("2", "b");
        linkedHashMap.put("1", "a");

        Iterator<String> iteratorLinkedHashMap = linkedHashMap.keySet().iterator();

        System.out.println("LinkedHashMap-->");

        while (iteratorLinkedHashMap.hasNext()){

            Object key2 = iteratorLinkedHashMap.next();
            System.out.println(key2 + "--" + linkedHashMap.get(key2));
        }

        //TreeMap
        TreeMap<String,String> treeMap = new TreeMap();
        treeMap.put("4", "d");
        treeMap.put("3", "c");
        treeMap.put("2", "b");
        treeMap.put("1", "a");

        Iterator<String> iteratorTreeMap = treeMap.keySet().iterator();

        System.out.println("TreeMap-->");

        while (iteratorTreeMap.hasNext()){

            Object key3 = iteratorTreeMap.next();
            System.out.println(key3 + "--" + treeMap.get(key3));
        }

    }

}
