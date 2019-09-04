public class Node<T> {
    Node<T> l = null;
    Node<T> r = null;
    T value;

    Node(T value) {
        this.value = value;
    }
}