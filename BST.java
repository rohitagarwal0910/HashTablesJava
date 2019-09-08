public class BST<K extends Comparable<K>, T> {
    Node<K, T> head = null;

    public int add(K key, T obj) {
        int r = 1;
        if (head == null) {
            head = new Node<K, T>(new Entry<K, T>(key, obj));
            return r;
        }
        Node<K, T> node = head;
        while (true) {
            r++;
            if (key.compareTo(node.value.key) < 0) {
                if (node.l == null) {
                    node.l = new Node<K, T>(new Entry<K, T>(key, obj));
                    return r;
                }
                node = node.l;
            } else if (key.compareTo(node.value.key) > 0) {
                if (node.r == null) {
                    node.r = new Node<K, T>(new Entry<K, T>(key, obj));
                    return r;
                }
                node = node.r;
            }
        }
    }

    public int update(K key, T obj) {
        int r = 0;
        Node<K, T> node = head;
        if (head == null)
            return -1;
        while (true) {
            r++;
            if (key.toString().equals(node.value.key.toString())) {
                node.value.entity = obj;
                return r;
            } else if (key.compareTo(node.value.key) < 0) {
                if (node.l == null) {
                    return -1;
                }
                node = node.l;
            } else if (key.compareTo(node.value.key) > 0) {
                if (node.r == null) {
                    return -1;
                }
                node = node.r;
            } else if (key.compareTo(node.value.key) == 0) {

            }
        }
    }

    public int delete(K key) {
        int r = 0;
        Node<K, T> node = head;
        Node<K, T> pnode = head;
        if (head == null)
            return -1;
        while (true) {
            r++;
            if (key.toString().equals(node.value.key.toString())) {
                break;
            }
            pnode = node;
            if (key.compareTo(node.value.key) < 0) {
                if (node.l == null) {
                    return -1;
                }
                node = node.l;
            } else if (key.compareTo(node.value.key) > 0) {
                if (node.r == null) {
                    return -1;
                }
                node = node.r;
            } else if (key.compareTo(node.value.key) == 0) {

            }
        }
        if (node.l == null && node.r == null) {
            if (node == head) {
                head = null;
            } else if (node == pnode.l) {
                pnode.l = null;
            } else if (node == pnode.r) {
                pnode.r = null;
            }
        } else if (node.l == null) {
            r++;
            node.value = node.r.value;
            node.l = node.r.l;
            node.r = node.r.r;
        } else if (node.r == null) {
            r++;
            node.value = node.l.value;
            node.r = node.l.r;
            node.l = node.l.l;
        } else {
            r++;
            Node<K, T> n = node.l;
            Node<K, T> p = node;
            if (n.r == null) {
                node.value = n.value;
                node.l = n.l;
            }
            while (true) {
                if (n.r == null) {
                    node.value = n.value;
                    p.r = n.l;
                    break;
                } else {
                    r++;
                    p = n;
                    n = n.r;
                }
            }
        }
        return r;
    }

    public boolean contains(K key) {
        Node<K, T> node = head;
        if (head == null)
            return false;
        while (true) {
            if (key.toString().equals(node.value.key.toString())) {
                return true;
            } else if (key.compareTo(node.value.key) < 0) {
                if (node.l == null) {
                    return false;
                }
                node = node.l;
            } else if (key.compareTo(node.value.key) > 0) {
                if (node.r == null) {
                    return false;
                }
                node = node.r;
            } else if (key.compareTo(node.value.key) == 0) {

            }
        }
    }

    public T get(K key) throws NotFoundException {
        Node<K, T> node = head;
        if (head == null)
            throw new NotFoundException();
        while (true) {
            if (key.toString().equals(node.value.key.toString())) {
                return node.value.entity;
            } else if (key.compareTo(node.value.key) < 0) {
                if (node.l == null) {
                    throw new NotFoundException();
                }
                node = node.l;
            } else if (key.compareTo(node.value.key) > 0) {
                if (node.r == null) {
                    throw new NotFoundException();
                }
                node = node.r;
            } else if (key.compareTo(node.value.key) == 0) {

            }
        }
    }

    public String address(K key) throws NotFoundException {
        Node<K, T> node = head;
        String steps = "";
        if (head == null)
            throw new NotFoundException();
        while (true) {
            if (key.toString().equals(node.value.key.toString())) {
                return steps;
            } else if (key.compareTo(node.value.key) < 0) {
                if (node.l == null) {
                    throw new NotFoundException();
                }
                steps = steps + "L";
                node = node.l;
            } else if (key.compareTo(node.value.key) > 0) {
                if (node.r == null) {
                    throw new NotFoundException();
                }
                steps = steps + "R";
                node = node.r;
            } else if (key.compareTo(node.value.key) == 0) {

            }
        }
    }
}