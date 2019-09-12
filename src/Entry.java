public class Entry<K extends Comparable<K>, T> {
    K key;
    T entity;

    Entry(K k, T t) {
        key = k;
        entity = t;
    }
}