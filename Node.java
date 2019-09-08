public class Node<K extends Comparable<K>, T> {
    Node<K, T> l = null;
    Node<K, T> r = null;
    Entry<K, T> value;

    Node(Entry<K, T> value) {
        this.value = value;
    }
}