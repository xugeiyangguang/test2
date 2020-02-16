/*
package Leetcode;

import java.util.*;

public class Test{
    public static void main(String[] args) {

    }
}
public class Hashtable<K,V>
        extends Dictionary<K,V>      //继承 Dictionary表示键值对，是一个旧类，现在用Map代替
        implements Map<K,V>, Cloneable, java.io.Serializable {

    //申明hashTable
    private transient Hashtable.Entry<?,?>[] table;
    //hashtable中总的元素个数
    private transient int count;
    //HashMap的极限容量，扩容临界点（容量和加载因子的乘积）
    private int threshold;
    //装载因子
    private float loadFactor;


    //hashtable结构修改的次数
    private transient int modCount = 0;
    //serialVersionUID from JDK 1.0.2 for interoperability
    private static final long serialVersionUID = 1421746759512286392L;

    */
/**
     * @param      initialCapacity    hashtable的初始容量.
     * @param      loadFactor         hashtable的装载因子.
     * @exception IllegalArgumentException  如果initialCapacity<=0 || loadFactor <= 0
     *//*


    //创建用户指定初始容量大小和加载因子的hashtable
    public Hashtable(int initialCapacity, float loadFactor) {
        //如果初始容量<0
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        //如果初始容量<=0 或者 初始容量是NaN 非数
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal Load: "+loadFactor);
        //如果初始容量为0，将初始容量设置为1
        if (initialCapacity==0)
            initialCapacity = 1;
        //装载因此设为用户自定义的
        this.loadFactor = loadFactor;
        //建立一个初始容量为initialCapacity的hashtable
        table = new java.util.Hashtable.Entry<?,?>[initialCapacity];
        //初始的扩容临界点为  加载因子*初始容量 || Integer.MAX_VALUE - 8 ??????
        threshold = (int)Math.min(initialCapacity * loadFactor, MAX_ARRAY_SIZE + 1);

    }

    //创建用户指定初始容量大小的hashtable，加载因子默认0.75f
    public Hashtable(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }
    //创建默认初始容量大小： 11 和加载因子： 0.75f 的hashtable
    public Hashtable() {
        this(11, 0.75f);
    }

    //以映射t创建为hashtable
    public Hashtable(Map<? extends K, ? extends V> t) {
        this(Math.max(2*t.size(), 11), 0.75f);
        putAll(t);
    }

    //使用value对hashMap排序 constructor chained from {@link Properties} keeps Hashtable fields
    //     uninitialized since they are not used.
    Hashtable(Void dummy) {}

    //返回hashtable目前的元素个数
    public synchronized int size() {
        return count;
    }
    //判断哈希表是否为空
    public synchronized boolean isEmpty() {
        return count == 0;
    }

    //返回当前哈希表的所有键
    public synchronized Enumeration<K> keys() {
        return this.<K>getEnumeration(KEYS);
    }
    //返回当前哈希表的所有与值
    public synchronized Enumeration<V> elements() {
        return this.<V>getEnumeration(VALUES);
    }

    //判断当前哈希表是否包含指定的值
    public synchronized boolean contains(Object value) {
        //如果查找的值为空，返回异常
        if (value == null) {
            throw new NullPointerException();
        }
        //保存当前哈希表的副本，在副本中查找值，不是当前哈希表中查找
        Entry<?,?> tab[] = table;
        //外层是数组循环
        for (int i = tab.length ; i-- > 0 ;) {
            //内层是链表循环
            for (Entry<?,?> e = tab[i]; e != null ; e = e.next) {
                if (e.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean containsValue(Object value) {
        return contains(value);
    }

    //哈希表中是否有指定的键
    public synchronized boolean containsKey(Object key) {
        //得到当前哈希表的键值对副本
        Entry<?,?> tab[] = table;
        //得到指定键的哈希值
        int hash = key.hashCode();
        //根据hash值得到对应的索引下标
        int index = (hash & 0x7FFFFFFF) % tab.length;
        //从得到的下标开始，在该索引链接的链中查找指定的键，因为可能发生了冲突，所以要不断的往后找
        for (Entry<?,?> e = tab[index]; e != null ; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    //根据指定的键，返回该键对应的值
    public synchronized V get(Object key) {
        Entry<?,?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<?,?> e = tab[index]; e != null ; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                return (V)e.value;
            }
        }
        return null;
    }

    //数组最大的容量，一些虚拟机在数组中保存了header words（占用8位）  ？？
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    //哈希表的重建，当当前哈希表的元素超过了threshold，就会自动调用此方法进行扩容
    protected void rehash() {
        //旧的容量
        int oldCapacity = table.length;
        //当前哈希表的副本
        java.util.Hashtable.Entry<?,?>[] oldMap = table;

        // 新的哈希表的容量=原始容量*2+1
        int newCapacity = (oldCapacity << 1) + 1;
        //如果哈希表的容量超过了规定的数组得到最大值
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            //如果旧的容量已经等于允许的最大空间，继续使用原来的哈希表
            if (oldCapacity == MAX_ARRAY_SIZE)
                // Keep running with MAX_ARRAY_SIZE buckets
                return;
            //将新的哈希表的容量设置为允许的最大值
            newCapacity = MAX_ARRAY_SIZE;
        }
        //以新的容量大小创建一个新的哈希表
        java.util.Hashtable.Entry<?,?>[] newMap = new java.util.Hashtable.Entry<?,?>[newCapacity];
        //哈希表修改的次数增加
        modCount++;
        //改变当前哈希表的扩容临界值
        threshold = (int)Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
        //将指向旧哈希表的引用指向新的哈希表
        table = newMap;
        //将旧的哈希表的元素逐个放置到新的哈希表中
        //外层为数组的遍历
        for (int i = oldCapacity ; i-- > 0 ;) {
            //内层为链表的遍历
            for (java.util.Hashtable.Entry<K,V> old = (java.util.Hashtable.Entry<K,V>)oldMap[i]; old != null ; ) {
                java.util.Hashtable.Entry<K,V> e = old;
                old = old.next;
                //计算该节点在新的哈希表中的位置
                int index = (e.hash & 0x7FFFFFFF) % newCapacity;
                //采用头插法的方式插入新的链表
                e.next = (java.util.Hashtable.Entry<K,V>)newMap[index];
                newMap[index] = e;
            }
        }
    }

    //指定的索引处，增加新的键值对
    private void addEntry(int hash, K key, V value, int index) {
        //得到哈希表的副本
        java.util.Hashtable.Entry<?,?> tab[] = table;
        //如果当前表中的元素个数>=扩容临界值，就对当前哈希表进行扩容重建
        if (count >= threshold) {
            // Rehash the table if the threshold is exceeded
            rehash();

            tab = table;
            //得到插入元素在新表中的索引下标
            hash = key.hashCode();
            index = (hash & 0x7FFFFFFF) % tab.length;
        }

        // Creates the new entry.
        //采用头插法，在得到的索引位置插入该元素
        @SuppressWarnings("unchecked")
        java.util.Hashtable.Entry<K,V> e = (java.util.Hashtable.Entry<K,V>) tab[index];
        tab[index] = new java.util.Hashtable.Entry<>(hash, key, value, e);
        //表的元素+1
        count++;
        //表的修改次数+1
        modCount++;
    }

    //增加元素到哈希表，如该键已经存在，更新value值，并返回旧的value值
    public synchronized V put(K key, V value) {
        // Make sure the value is not null
        if (value == null) {
            throw new NullPointerException();
        }

        // Makes sure the key is not already in the hashtable.
        java.util.Hashtable.Entry<?,?> tab[] = table;
        //根据键值，得到该元素所在的索引下标处
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        java.util.Hashtable.Entry<K,V> entry = (java.util.Hashtable.Entry<K,V>)tab[index];
        //如果已经存在相同键值的元素，则将原来的元素覆盖，并且返回该键值对应的旧的value值
        for(; entry != null ; entry = entry.next) {
            if ((entry.hash == hash) && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }
        //增加键值对
        addEntry(hash, key, value, index);
        return null;
    }

    //删除指定键的元素，或者返回该键对应的value值，或者返回null（不存在对应的键值）
    public synchronized V remove(Object key) {
        java.util.Hashtable.Entry<?,?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        java.util.Hashtable.Entry<K,V> e = (java.util.Hashtable.Entry<K,V>)tab[index];
        for(java.util.Hashtable.Entry<K,V> prev = null; e != null ; prev = e, e = e.next) {
            //如果找到有对应的键
            if ((e.hash == hash) && e.key.equals(key)) {
                //如果该元素不是在头结点，
                if (prev != null) {
                    prev.next = e.next;

                } else {
                    //如果该元素是在头结点，
                    tab[index] = e.next;
                }
                //表修改的次数+1
                modCount++;
                count--;
                V oldValue = e.value;
                e.value = null;
                //返回该键对应的value值
                return oldValue;
            }
        }
        //如果没有找到对应的键，则返回null
        return null;
    }

    //将指定映射的所有键值对加入当前的哈希表中
    public synchronized void putAll(Map<? extends K, ? extends V> t) {
        for (Map.Entry<? extends K, ? extends V> e : t.entrySet())
            put(e.getKey(), e.getValue());
    }

    //清空哈希表，
    public synchronized void clear() {
        java.util.Hashtable.Entry<?,?> tab[] = table;
        for (int index = tab.length; --index >= 0; )
            tab[index] = null;
        modCount++;
        count = 0;
    }

    //哈希表的浅复制，只复制哈希表的结构，不复制key和value值
    public synchronized Object clone() {
        java.util.Hashtable<?,?> t = cloneHashtable();
        t.table = new java.util.Hashtable.Entry<?,?>[table.length];
        for (int i = table.length ; i-- > 0 ; ) {
            t.table[i] = (table[i] != null)
                    ? (java.util.Hashtable.Entry<?,?>) table[i].clone() : null;
        }
        t.keySet = null;
        t.entrySet = null;
        t.values = null;
        t.modCount = 0;
        return t;
    }
    final java.util.Hashtable<?,?> cloneHashtable() {
        try {
            return (java.util.Hashtable<?,?>)super.clone();
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }

    //重写toString（）
    public synchronized String toString() {
        int max = size() - 1;
        if (max == -1)
            return "{}";

        StringBuilder sb = new StringBuilder();
        //返回迭代器
        Iterator<Entry<K,V>> it = entrySet().iterator();

        sb.append('{');
        for (int i = 0; ; i++) {
            Map.Entry<K,V> e = it.next();
            K key = e.getKey();
            V value = e.getValue();
            sb.append(key   == this ? "(this Map)" : key.toString());
            sb.append('=');
            sb.append(value == this ? "(this Map)" : value.toString());

            if (i == max)
                return sb.append('}').toString();
            sb.append(", ");
        }
    }

    private <T> Enumeration<T> getEnumeration(int type) {
        if (count == 0) {
            return Collections.emptyEnumeration();
        } else {
            return new java.util.Hashtable.Enumerator<>(type, false);
        }
    }

    private <T> Iterator<T> getIterator(int type) {
        if (count == 0) {
            return Collections.emptyIterator();
        } else {
            return new java.util.Hashtable.Enumerator<>(type, true);
        }
    }
}
*/
