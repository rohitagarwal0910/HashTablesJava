public class DH<K extends Comparable<K>, T> implements MyHashTable_<K, T> {
    int t;
    Entry<K, T> list[];
    boolean check[];

    DH(int t) {
        this.t = t;
        list = new Entry[t];
        check = new boolean[t];

        for (int i = 0; i < this.t; i++) {
            check[i] = false;
        }
    }

    @Override
    public int insert(K key, T obj) {
        int index = (int) Hash.djb2(key.toString(), t);
        int step = (int) Hash.sdbm(key.toString(), t);
        int i = 0;
        boolean b = false;
        int finalindex = index;
        for (int j = 0; j < t + 1; j++) {
            if (b == false) {
                i++;
            }
            if (list[index] == null && b == false) {
                finalindex = index;
                b = true;
            }
            if (list[index] == null && check[i] == false) {
                break;
            }
            if (list[index] != null
                    && (list[index].key.toString().equals(key.toString()) && list[index].key.compareTo(key) == 0)) {
                return -1;
            }
            index = (index + step) % t;
        }
        if (b == true) {
            list[finalindex] = new Entry<K, T>(key, obj);
            return i;
        } else
            return -1;
    }

    @Override
    public int update(K key, T obj) {
        int index;
        int initindex = (int) Hash.djb2(key.toString(), t);
        int step = (int) Hash.sdbm(key.toString(), t);
        int i = 0;
        int n = -1;
        while (true) {
            index = (int) ((initindex + i * step) % t);
            if (i == 1)
                n = index;
            if (i != 1 && index == n)
                break;
            if (list[index] == null && check[index] == true) {
                i++;
                continue;
            }
            if (list[index] == null && check[index] == false) {
                return -1;
            }
            if (list[index].key.toString().equals(key.toString()) && list[index].key.compareTo(key) == 0)
                break;
            i++;
        }
        if (list[index] == null || !list[index].key.toString().equals(key.toString())
                || list[index].key.compareTo(key) != 0)
            i = -2;
        else
            list[index] = new Entry<K, T>(key, obj);
        return i + 1;
    }

    @Override
    public int delete(K key) {
        int index;
        int initindex = (int) Hash.djb2(key.toString(), t);
        int step = (int) Hash.sdbm(key.toString(), t);
        int i = 0;
        int n = -1;
        while (true) {
            index = (int) ((initindex + i * step) % t);
            if (i == 1)
                n = index;
            if (i != 1 && index == n)
                break;
            if (list[index] == null && check[index] == true) {
                i++;
                continue;
            }
            if (list[index] == null && check[index] == false) {
                return -1;
            }
            if (list[index].key.toString().equals(key.toString()) && list[index].key.compareTo(key) == 0)
                break;
            i++;
        }
        if (list[index] == null || !list[index].key.toString().equals(key.toString())
                || list[index].key.compareTo(key) != 0)
            i = -2;
        else {
            list[index] = null;
            check[index] = true;
        }
        return i + 1;
    }

    @Override
    public boolean contains(K key) {
        int index = getIndex(key);
        return (list[index] != null && list[index].key.toString().equals(key.toString())
                && list[index].key.compareTo(key) == 0) ? true : false;
    }

    @Override
    public T get(K key) throws NotFoundException {
        int index = getIndex(key);
        if (list[index] == null || !list[index].key.toString().equals(key.toString())
                || list[index].key.compareTo(key) != 0) {
            throw new NotFoundException();
        }
        return list[index].entity;
    }

    @Override
    public String address(K key) throws NotFoundException {
        int index = getIndex(key);
        if (list[index] == null || !list[index].key.toString().equals(key.toString())
                || list[index].key.compareTo(key) != 0) {
            throw new NotFoundException();
        }
        return Integer.toString(index);
    }

    public int getIndex(K key) {
        int index;
        int initindex = (int) Hash.djb2(key.toString(), t);
        int step = (int) Hash.sdbm(key.toString(), t);
        int i = 0;
        int n = -1;
        while (true) {
            index = (int) ((initindex + i * step) % t);
            if (i == 1)
                n = index;
            if (i != 1 && index == n)
                break;
            if (list[index] == null && check[index] == true) {
                i++;
                continue;
            }
            if (list[index] == null && check[index] == false) {
                break;
            }
            if (list[index].key.toString().equals(key.toString()) && list[index].key.compareTo(key) == 0)
                break;
            i++;
        }
        return index;
    }

}