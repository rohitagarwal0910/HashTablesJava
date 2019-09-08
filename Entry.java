public class Entry<K extends Comparable<K>, T> implements Comparable<Entry<K, T>> {
    K key;
    T entity;

    Entry(K k, T t) {
        key = k;
        entity = t;
    }

    @Override
    public int compareTo(Entry<K, T> o) {
        return key.compareTo(o.key);
    }
}