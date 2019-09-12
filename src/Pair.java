public class Pair<K extends Comparable<K>, T> implements Comparable<Pair<K, T>> {
    K first;
    T second;

    Pair(K k, T t) {
        first = k;
        second = t;
    }

    @Override
    public int compareTo(Pair<K, T> o) {
        return (first.compareTo(o.first));
    }

    @Override
    public String toString() {
        return first.toString() + second.toString();
    }
}