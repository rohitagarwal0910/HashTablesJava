public class DH<K extends Comparable<K>, T> implements MyHashTable_<K, T> {
    int t;
    Entry<K, T> list[];

    DH(int t) {
        this.t = t;
        list = new Entry[t];
    }

    @Override
    public int insert(K key, T obj) {
        int index = (int) Hash.djb2(key.toString(), t);
        int i = 1;
        while (list[index] != null) {
            index = (int) ((Hash.djb2(key.toString(), t) + i * Hash.sdbm(key.toString(), t)) % t);
            i++;
        }
        list[index] = new Entry<K, T>(key, obj);
        return i;
    }

    @Override
    public int update(K key, T obj) {
        int index;
        int i = 0;
        int n = -1;
        while (true) {
            index = (int) ((Hash.djb2(key.toString(), t) + i * Hash.sdbm(key.toString(), t)) % t);
            if (i == 1)
                n = index;
            if (i != 1 && index == n)
                break;
            if (list[index] == null) {
                i++;
                continue;
            }
            if (list[index].key.toString().equals(key.toString()))
                break;
            i++;
        }
        if (list[index] == null || !list[index].key.toString().equals(key.toString()))
            i = -2;
        else
            list[index] = new Entry<K, T>(key, obj);
        return i + 1;
    }

    @Override
    public int delete(K key) {
        int index;
        int i = 0;
        int n = -1;
        while (true) {
            index = (int) ((Hash.djb2(key.toString(), t) + i * Hash.sdbm(key.toString(), t)) % t);
            if (i == 1)
                n = index;
            if (i != 1 && index == n)
                break;
            if (list[index] == null) {
                i++;
                continue;
            }
            if (list[index].key.toString().equals(key.toString()))
                break;
            i++;
        }
        if (list[index] == null || !list[index].key.toString().equals(key.toString()))
            i = -2;
        else
            list[index] = null;
        return i + 1;
    }

    @Override
    public boolean contains(K key) {
        int index = getIndex(key);
        return (list[index] != null && list[index].key.toString().equals(key.toString())) ? true : false;
    }

    @Override
    public T get(K key) throws NotFoundException {
        int index = getIndex(key);
        if (list[index] == null || !list[index].key.toString().equals(key.toString())) {
            throw new NotFoundException();
        }
        return list[index].entity;
    }

    @Override
    public String address(K key) throws NotFoundException {
        int index = getIndex(key);
        if (list[index] == null || !list[index].key.toString().equals(key.toString())) {
            throw new NotFoundException();
        }
        return Integer.toString(index);
    }

    public int getIndex(K key) {
        int index;
        int i = 0;
        int n = -1;
        while (true) {
            index = (int) ((Hash.djb2(key.toString(), t) + i * Hash.sdbm(key.toString(), t)) % t);
            if (i == 1)
                n = index;
            if (i != 1 && index == n)
                break;
            if (list[index] == null) {
                i++;
                continue;
            }
            if (list[index].key.toString().equals(key.toString()))
                break;
            i++;
        }
        return index;
    }

}