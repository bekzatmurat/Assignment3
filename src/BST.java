import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size = 0;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
        size++;
    }

    private Node put(Node x, K key, V val) {
        if (x == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        return x;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        Node x = get(root, key);
        if (x == null) return null;
        return x.val;
    }

    private Node get(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x;
    }

    public void inorder(Node x, List<K> keys) {
        if (x == null) return;
        inorder(x.left, keys);
        keys.add(x.key);
        inorder(x.right, keys);
    }

    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inorder(root, keys);
        return keys;
    }

    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(10, "Ten");
        tree.put(5, "Five");
        tree.put(20, "Twenty");
        tree.put(15, "Fifteen");

        for (Integer key : tree.iterator()) {
            System.out.println("key is " + key + " and value is " + tree.get(key));
        }
    }
}
