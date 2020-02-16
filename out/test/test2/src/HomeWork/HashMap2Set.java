package HomeWork;

import java.util.HashMap;

public class HashMap2Set {
    public static void main(String[] args) {
        MyHashSet<String> hashSet = new MyHashSet<>();
        hashSet.add("xiaoming");
        hashSet.add("xiaoming");
        hashSet.add("xiaoming");

        System.out.println(hashSet.size());
    }
}

class MyHashSet<E> {
    private HashMap<E, Object> hashMap;
    private Object object = new Object();

    public MyHashSet() {
        hashMap = new HashMap<>();
    }

    public void add(E e) {
        hashMap.put(e, object);
    }

    public int size() {
        return hashMap.size();
    }

    public void remove(E e) {
        hashMap.remove(e);
    }
}
/*
class MyHashSet<E> {

    private HashMap<E,Object> map;

    //作为所有元素的同意value
    private static final Object PRESENT = new Object();

    public MyHashSet() {
        map = new HashMap<>();
    }

    public int size() {
        return map.size();
    }

    public void add(E e) {
        map.put(e, PRESENT);
    }

    public void remove(E e) {
        map.remove(e);
    }

}
*/
