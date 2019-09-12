public class BST<K extends Comparable<K>, T> {
    Node<K, T> head = null;

    public int add(K key, T obj) {
        int r = 1;
        // if (contains(key))
        // return -1;
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
            } else if (key.compareTo(node.value.key) == 0) {
                if (key.toString().compareTo(node.value.key.toString()) == 0) {
                    return -1;
                } else if (key.toString().compareTo(node.value.key.toString()) < 0) {
                    if (node.l == null) {
                        node.l = new Node<K, T>(new Entry<K, T>(key, obj));
                        return r;
                    }
                    node = node.l;
                } else if (key.toString().compareTo(node.value.key.toString()) > 0) {
                    if (node.r == null) {
                        node.r = new Node<K, T>(new Entry<K, T>(key, obj));
                        return r;
                    }
                    node = node.r;
                }
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
            if (key.toString().compareTo(node.value.key.toString()) == 0 && key.compareTo(node.value.key) == 0) {
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
                if (key.toString().compareTo(node.value.key.toString()) < 0) {
                    if (node.l == null) {
                        return -1;
                    }
                    node = node.l;
                } else if (key.toString().compareTo(node.value.key.toString()) > 0) {
                    if (node.r == null) {
                        return -1;
                    }
                    node = node.r;
                }
            }
        }
    }

    public int delete(K key) {
        int r = 0;
        Node<K, T> node = head;
        Node<K, T> pnode = head;
        if (head == null)
            return -1;
        // while (true) {
        // r++;
        // if (key.toString().compareTo(node.value.key.toString()) == 0 &&
        // key.compareTo(node.value.key) == 0) {
        // break;
        // }
        // pnode = node;
        // if (key.compareTo(node.value.key) < 0) {
        // if (node.l == null) {
        // return -1;
        // }
        // node = node.l;
        // } else if (key.compareTo(node.value.key) > 0) {
        // if (node.r == null) {
        // return -1;
        // }
        // node = node.r;
        // } else if (key.compareTo(node.value.key) == 0) {
        // if (key.toString().compareTo(node.value.key.toString()) < 0) {
        // if (node.l == null) {
        // return -1;
        // }
        // node = node.l;
        // } else if (key.toString().compareTo(node.value.key.toString()) > 0) {
        // if (node.r == null) {
        // return -1;
        // }
        // node = node.r;
        // }
        // }
        // }
        while (true) {
            r++;
            if (key.toString().compareTo(node.value.key.toString()) == 0 && key.compareTo(node.value.key) == 0) {
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
                if (key.toString().compareTo(node.value.key.toString()) < 0) {
                    if (node.l == null) {
                        return -1;
                    }
                    node = node.l;
                } else if (key.toString().compareTo(node.value.key.toString()) > 0) {
                    if (node.r == null) {
                        return -1;
                    }
                    node = node.r;
                }
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
        } else if (node.l == null && node.r != null) {
            r++;
            node.value = node.r.value;
            node.l = node.r.l;
            node.r = node.r.r;
        } else if (node.r == null && node.l != null) {
            r++;
            node.value = node.l.value;
            node.r = node.l.r;
            node.l = node.l.l;
        } else if (node.r != null && node.l != null) {
            r++;
            Node<K, T> n = node.l;
            Node<K, T> p = node;
            if (n.r == null) {
                node.value = n.value;
                node.l = n.l;
            } else {
                while (true) {
                    if (n.r == null) {
                        node.value = n.value;
                        p.r = n.l;
                        if (p.r != null)
                            r++;
                        break;
                    } else {
                        r++;
                        p = n;
                        n = n.r;
                    }
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
            if (key.toString().compareTo(node.value.key.toString()) == 0 && key.compareTo(node.value.key) == 0) {
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
                if (key.toString().compareTo(node.value.key.toString()) < 0) {
                    if (node.l == null) {
                        return false;
                    }
                    node = node.l;
                } else if (key.toString().compareTo(node.value.key.toString()) > 0) {
                    if (node.r == null) {
                        return false;
                    }
                    node = node.r;
                }
            }
        }
    }

    public T get(K key) throws NotFoundException {
        Node<K, T> node = head;
        if (head == null)
            throw new NotFoundException();
        while (true) {
            if (key.toString().compareTo(node.value.key.toString()) == 0 && key.compareTo(node.value.key) == 0) {
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
                if (key.toString().compareTo(node.value.key.toString()) < 0) {
                    if (node.l == null) {
                        throw new NotFoundException();
                    }
                    node = node.l;
                } else if (key.toString().compareTo(node.value.key.toString()) > 0) {
                    if (node.r == null) {
                        throw new NotFoundException();
                    }
                    node = node.r;
                }
            }
        }
    }

    public String address(K key) throws NotFoundException {
        Node<K, T> node = head;
        String steps = "";
        if (head == null)
            throw new NotFoundException();
        while (true) {
            if (key.toString().compareTo(node.value.key.toString()) == 0 && key.compareTo(node.value.key) == 0) {
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
                if (key.toString().compareTo(node.value.key.toString()) < 0) {
                    if (node.l == null) {
                        throw new NotFoundException();
                    }
                    node = node.l;
                } else if (key.toString().compareTo(node.value.key.toString()) > 0) {
                    if (node.r == null) {
                        throw new NotFoundException();
                    }
                    node = node.r;
                }
            }
        }
    }
}