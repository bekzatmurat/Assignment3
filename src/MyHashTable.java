import java.util.LinkedList;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private LinkedList<HashNode<K, V>>[] chainArray;
    private int M = 32;
    private int size = 0;

    public MyHashTable() {
        chainArray = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            chainArray[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        int hash = key.hashCode();
        return Math.abs(hash % M);
    }

    public void put(K key, V value) {
        int index = hash(key);
        for (HashNode<K, V> node : chainArray[index]) {
            if (node.key.equals(key)) {
                node.value = value; // Обновить значение, если ключ уже существует
                return;
            }
        }
        chainArray[index].add(new HashNode<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        for (HashNode<K, V> node : chainArray[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        for (HashNode<K, V> node : chainArray[index]) {
            if (node.key.equals(key)) {
                chainArray[index].remove(node);
                size--;
                return node.value;
            }
        }
        return null;
    }

    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            for (HashNode<K, V> node : chainArray[i]) {
                if (node.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            for (HashNode<K, V> node : chainArray[i]) {
                if (node.value.equals(value)) {
                    return node.key;
                }
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int getBucketSize(int index) {
        if (index < 0 || index >= M) {
            throw new IndexOutOfBoundsException("Invalid bucket index");
        }
        return chainArray[index].size();
    }
}