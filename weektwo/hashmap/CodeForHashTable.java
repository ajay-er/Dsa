package hashmap;

import java.util.LinkedList;

public class CodeForHashTable {
    static class HashTable<K, V> {
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        LinkedList<Node>[] buckets;

        HashTable() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        boolean isEmpty() {
            return n == 0;
        }

        V get(K key) {
            int bi = hash(key);
            int di = searchinLL(bi, key);

            if (di == -1) {
                return null;
            } else {
                return buckets[bi].get(di).value;
            }
        }

        void put(K key, V value) {
            int bi = hash(key);
            int di = searchinLL(bi, key);

            if (di == -1) {
                buckets[bi].add(new Node(key, value));
                n++;
            } else {
                buckets[bi].get(di).value = value;
            }
        }

        private int searchinLL(int bi, K key) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        private int hash(K key) {
            int index = hashFunction(key);
            return Math.abs(index) % N;
        }

        private int hashFunction(K key) {
            String str = key.toString();
            int hash = 0;
            for (int i = 0; i < str.length(); i++) {
                hash = (hash * 31 + str.charAt(i));
            }
            return hash;
        }

    }
}
