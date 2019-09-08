public class SC<K extends Comparable<K>, T> implements MyHashTable_<K, T> {
    int t;
    BST<K, T> list[];

    SC(int t) {
        this.t = t;
        list = new BST[t];
        for (int i = 0; i < t; i++) {
            list[i] = new BST<K, T>();
        }
    }

    @Override
    public int insert(K key, T obj) {

        int index = (int) Hash.djb2(key.toString(), t);
        return list[index].add(key, obj);
    }

    @Override
    public int update(K key, T obj) {

        int index = (int) Hash.djb2(key.toString(), t);
        return list[index].update(key, obj);
    }

    @Override
    public int delete(K key) {

        int index = (int) Hash.djb2(key.toString(), t);
        return list[index].delete(key);
    }

    @Override
    public boolean contains(K key) {

        int index = (int) Hash.djb2(key.toString(), t);
        return list[index].contains(key);
    }

    @Override
    public T get(K key) throws NotFoundException {

        int index = (int) Hash.djb2(key.toString(), t);
        try {
            return list[index].get(key);
        } catch (NotFoundException e) {
            throw e;
        }
    }

    @Override
    public String address(K key) throws NotFoundException {

        int index = (int) Hash.djb2(key.toString(), t);
        try {
            return Integer.toString(index) + "-" + list[index].address(key);
        } catch (NotFoundException e) {
            throw e;
        }
    }

}