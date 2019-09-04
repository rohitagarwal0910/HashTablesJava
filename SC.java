public class SC<K, T> implements MyHashTable_<K, T> {
    int t;
    BST<T> list[];

    SC(int t) {
        this.t = t;
        list = new BST[t];
        for (int i = 0; i < t; i++) {
            list[i] = new BST();
        }
    }

    @Override
    public int insert(K key, T obj) {
        Pair<String, String> p = (Pair<String, String>) key;
        int index = (int) Hash.djb2(p.first + p.second, t);
        return list[index].add(obj);
    }

    @Override
    public int update(K key, T obj) {
        Pair<String, String> p = (Pair<String, String>) key;
        int index = (int) Hash.djb2(p.first + p.second, t);
        return list[index].update(obj, p);
    }

    @Override
    public int delete(K key) {
        Pair<String, String> p = (Pair<String, String>) key;
        int index = (int) Hash.djb2(p.first + p.second, t);
        return list[index].delete(p);
    }

    @Override
    public boolean contains(K key) {
        Pair<String, String> p = (Pair<String, String>) key;
        int index = (int) Hash.djb2(p.first + p.second, t);
        return list[index].contains(p);
    }

    @Override
    public T get(K key) throws NotFoundException {
        Pair<String, String> p = (Pair<String, String>) key;
        int index = (int) Hash.djb2(p.first + p.second, t);
        try {
            return list[index].get(p);
        } catch (NotFoundException e) {
            throw e;
        }
    }

    @Override
    public String address(K key) throws NotFoundException {
        Pair<String, String> p = (Pair<String, String>) key;
        int index = (int) Hash.djb2(p.first + p.second, t);
        try {
            return Integer.toString(index) + "-" + list[index].address(p);
        } catch (NotFoundException e) {
            throw e;
        }
    }

}