import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by W
 * Date: 2020-05-20 00:36
 * Description
 */
public class LRU<K, V> {
    static class Node<K, V> {
        K key;
        V value;
        Node next;
        Node prev;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    //双向链表
    class DoubleList {
        private Node first;
        private Node last;
        private int size;

        void addFirst(Node x) {
            x.next = first;
            if (first == null) {
                this.last = x;
            } else {
                first.prev = x;
            }
            this.first = x;
            size++;
        }


        void remove(Node x) {
            if (x.next == null) {
                removeLast();
            }
            if (x.prev == null) {
                //x 为 first
                this.first = x.next;
                first.prev = null;
            } else {
                x.prev.next = x.next;
                x.next.prev = x.prev;
            }
            size--;
        }

        //链表元素大于等于 1
        Node removeLast() {
            Node l = last;
            if(l == null){
                return null;
            }
            if (l == first) {
                this.last = null;
                this.first = null;
            } else {
                l.prev.next = null;
                last = l.prev;
            }
            size--;
            return last;
        }

        int size() {
            return size;
        }
    }

    HashMap<K, Node> map;
    DoubleList cache;
    private static final int CAPACITY = 5;

    V get(K key) {
        Node p = map.get(key);
        if (p == null) {
            //p不存在
            return null;
        }
        cache.remove(p);
        cache.addFirst(p);
        return (V) p.value;
    }

    void put(K key, V value) {
        if (map == null) {
            map = new HashMap<>();
            cache = new DoubleList();
        }
        Node newNode = new Node(key, value);
        Node oldNode;
        if ((oldNode = map.get(key)) != null) {
            //原来就存在,把旧数据删除，插入新数据
            map.put(key, newNode);
            cache.remove(oldNode);
            cache.addFirst(newNode);
        } else {
            //新插入的,需要判断之前是否已满
            map.put(key, newNode);
            if (cache.size >= CAPACITY) {
                cache.removeLast();
                map.remove(cache.last.key);
                cache.addFirst(newNode);
            } else {
                cache.addFirst(newNode);
            }
        }
    }

    @Override
    public String toString() {
        if (cache == null || cache.size == 0) return "";
        StringBuilder sb = new StringBuilder();
        Node p = cache.first;
        while (p != null) {
            sb.append("" + p.key + p.value);
            sb.append("\r\n");
            p = p.next;
        }
        return sb.toString();
    }
}
