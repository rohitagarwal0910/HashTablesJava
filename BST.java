public class BST<T> {
    Node<T> head = null;

    public int add(T obj) {
        int r = 1;
        if (head == null) {
            head = new Node<T>(obj);
            return r;
        }
        Student s = (Student) obj;
        Node<T> node = head;
        while (true) {
            r++;
            Student stc = (Student) node.value;
            if (s.fname().compareTo(stc.fname()) < 0) {
                if (node.l == null) {
                    node.l = new Node<T>(obj);
                    return r;
                }
                node = node.l;
            } else if (s.fname().compareTo(stc.fname()) > 0) {
                if (node.r == null) {
                    node.r = new Node<T>(obj);
                    return r;
                }
                node = node.r;
            }
        }
    }

    public int update(T obj, Pair<String, String> k) {
        int r = 0;
        Student s = (Student) obj;
        Node<T> node = head;
        if (head == null)
            System.out.println("bst update error not found");
        while (true) {
            r++;
            Student stc = (Student) node.value;
            if (k.first.equals(stc.fname()) && k.second.equals(stc.lname())) {
                node.value = obj;
                return r;
            } else if (k.first.compareTo(stc.fname()) < 0) {
                if (node.l == null) {
                    System.out.println("bst update error not found");
                    return -1;
                }
                node = node.l;
            } else if (k.first.compareTo(stc.fname()) > 0) {
                if (node.r == null) {
                    System.out.println("bst update error not found");
                    return -1;
                }
                node = node.r;
            } else if (k.first.equals(stc.fname())) {

            }
        }
    }

    public int delete(Pair<String, String> k) {
        int r = 0;
        Node<T> node = head;
        Node<T> pnode = head;
        if (head == null)
            System.out.println("bst delete error not found");
        while (true) {
            r++;
            Student stc = (Student) node.value;
            if (k.first.equals(stc.fname()) && k.second.equals(stc.lname())) {
                break;
            }
            pnode = node;
            if (k.first.compareTo(stc.fname()) < 0) {
                if (node.l == null) {
                    System.out.println("bst delete error not found");
                    break;
                }
                node = node.l;
            } else if (k.first.compareTo(stc.fname()) > 0) {
                if (node.r == null) {
                    System.out.println("bst delete error not found");
                    break;
                }
                node = node.r;
            } else if (k.first.equals(stc.fname())) {

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
            node.value = node.r.value;
            node.l = node.r.l;
            node.r = node.r.r;
        } else if (node.r == null) {
            node.value = node.l.value;
            node.r = node.l.r;
            node.l = node.l.l;
        } else {
            Node<T> n = node.l;
            while (true) {
                if (n.r == null) {
                    Student st = (Student) n.value;
                    Pair<String, String> p = new Pair<String, String>(st.fname(), st.lname());
                    delete(p);
                    node.value = n.value;
                    break;
                } else {
                    n = n.r;
                }
            }
        }
        return r;
    }

    public boolean contains(Pair<String, String> k) {
        Node<T> node = head;
        if (head == null)
            return false;
        while (true) {
            Student stc = (Student) node.value;
            if (k.first.equals(stc.fname()) && k.second.equals(stc.lname())) {
                return true;
            } else if (k.first.compareTo(stc.fname()) < 0) {
                if (node.l == null) {
                    return false;
                }
                node = node.l;
            } else if (k.first.compareTo(stc.fname()) > 0) {
                if (node.r == null) {
                    return false;
                }
                node = node.r;
            } else if (k.first.equals(stc.fname())) {

            }
        }
    }

    public T get(Pair<String, String> k) throws NotFoundException {
        Node<T> node = head;
        if (head == null)
            throw new NotFoundException();
        while (true) {
            Student stc = (Student) node.value;
            if (k.first.equals(stc.fname()) && k.second.equals(stc.lname())) {
                return node.value;
            } else if (k.first.compareTo(stc.fname()) < 0) {
                if (node.l == null) {
                    throw new NotFoundException();
                }
                node = node.l;
            } else if (k.first.compareTo(stc.fname()) > 0) {
                if (node.r == null) {
                    throw new NotFoundException();
                }
                node = node.r;
            } else if (k.first.equals(stc.fname())) {

            }
        }
    }

    public String address(Pair<String, String> k) throws NotFoundException {
        Node<T> node = head;
        String steps = "";
        if (head == null)
            throw new NotFoundException();
        while (true) {
            Student stc = (Student) node.value;
            if (k.first.equals(stc.fname()) && k.second.equals(stc.lname())) {
                return steps;
            } else if (k.first.compareTo(stc.fname()) < 0) {
                if (node.l == null) {
                    throw new NotFoundException();
                }
                steps = steps + "L";
                node = node.l;
            } else if (k.first.compareTo(stc.fname()) > 0) {
                if (node.r == null) {
                    throw new NotFoundException();
                }
                steps = steps + "R";
                node = node.r;
            } else if (k.first.equals(stc.fname())) {

            }
        }
    }
}