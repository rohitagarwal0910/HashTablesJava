public class DH<K, T> implements MyHashTable_<K, T> {
    int t;
    Student list[];

    DH(int t) {
        this.t = t;
        list = new Student[t];
    }

    @Override
    public int insert(K key, T obj) {
        Pair<String, String> p = (Pair<String, String>) key;
        // int index = (int) Hash.djb2(p.first + p.second, t);
        int index = (int) Hash.djb2(p.first + p.second, t);
        int i = 1;
        while (list[index] != null) {
            index = (int) ((Hash.djb2(p.first + p.second, t) + i * Hash.sdbm(p.first + p.second, t)) % t);
            i++;
        }
        list[index] = (Student) obj;
        return i;
    }

    @Override
    public int update(K key, T obj) {
        Pair<String, String> p = (Pair<String, String>) key;
        int index = (int) Hash.djb2(p.first + p.second, t);
        int i = 1;
        while (!list[index].fname().equals(p.first) && !list[index].lname().equals(p.second)) {
            index = (int) ((Hash.djb2(p.first + p.second, t) + i * Hash.sdbm(p.first + p.second, t)) % t);
            i++;
        }
        list[index] = (Student) obj;
        return i;
    }

    @Override
    public int delete(K key) {
        Pair<String, String> p = (Pair<String, String>) key;
        int index = (int) Hash.djb2(p.first + p.second, t);
        int i = 1;
        while (!list[index].fname().equals(p.first) && !list[index].lname().equals(p.second)) {
            index = (int) ((Hash.djb2(p.first + p.second, t) + i * Hash.sdbm(p.first + p.second, t)) % t);
            i++;
        }
        list[index] = null;
        return i;
    }

    @Override
    public boolean contains(K key) {
        Pair<String, String> p = (Pair<String, String>) key;
        // int index = (int) Hash.djb2(p.first + p.second, t);
        int index;
        int i = 0;
        int n = -1;
        while(true){
            index = (int) ((Hash.djb2(p.first + p.second, t) + i * Hash.sdbm(p.first + p.second, t)) % t);
        // while (list[index] != null && (!list[index].fname().equals(p.first) && !list[index].lname().equals(p.second))) {
            if (i==1) n = index;
            if (i!=1 && index == n) break;
            if (list[index] == null) {i++; continue;}
            if (list[index].fname().equals(p.first) && list[index].lname().equals(p.second)) break;
            i++;
        // }
        }
        return (list[index] == null) ? false : true;
    }

    @Override
    public T get(K key) throws NotFoundException {
        if (!contains(key))
            throw new NotFoundException();
        Pair<String, String> p = (Pair<String, String>) key;
        int index;
        int i = 0;
        int n = -1;
        while(true){
            index = (int) ((Hash.djb2(p.first + p.second, t) + i * Hash.sdbm(p.first + p.second, t)) % t);
        // while (list[index] != null && (!list[index].fname().equals(p.first) && !list[index].lname().equals(p.second))) {
            if (i==1) n = index;
            if (i!=1 && index == n) break;
            if (list[index] == null) {i++; continue;}
            if (list[index].fname().equals(p.first) && list[index].lname().equals(p.second)) break;
            i++;
        // }
        }
        return (T) list[index];
    }

    @Override
    public String address(K key) throws NotFoundException {
        if (!contains(key))
            throw new NotFoundException();
        Pair<String, String> p = (Pair<String, String>) key;
        int index;
        int i = 0;
        int n = -1;
        while(true){
            index = (int) ((Hash.djb2(p.first + p.second, t) + i * Hash.sdbm(p.first + p.second, t)) % t);
        // while (list[index] != null && (!list[index].fname().equals(p.first) && !list[index].lname().equals(p.second))) {
            if (i==1) n = index;
            if (i!=1 && index == n) break;
            if (list[index] == null) {i++; continue;}
            if (list[index].fname().equals(p.first) && list[index].lname().equals(p.second)) break;
            i++;
        // }
        }
        return Integer.toString(index);
    }

}