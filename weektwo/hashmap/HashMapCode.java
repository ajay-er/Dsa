package hashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;// number of link list nodes
        private int N;// number of buckets
        private LinkedList<Node>[] buckets;// N = buckets.length

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < buckets.length; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {// 0 to N-1
            int bi = key.hashCode();// 234567 -234567
            return Math.abs(bi) % N;
        }

        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;// di
                }
            }
            return -1;
        }

        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N * 2];

            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);// bucket index
            int di = SearchInLL(key, bi);// data index

            if (di == -1) {// key doesn't exist
                buckets[bi].add(new Node(key, value));
                n++;
            } else {// key exists
                Node data = buckets[bi].get(di);
                data.value = value;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                // rehashing
                rehash();
            }
        }

      public boolean containsKey(K key) {
            int bi = hashFunction(key);// bucket index
            int di = SearchInLL(key, bi);// data index

            if (di == -1) {// key doesn't exist
                return false;
            } else {// key exists
                return true;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);// bucket index
            int di = SearchInLL(key, bi);// data index

            if (di == -1) {// key doesn't exist
                return null;
            } else {// key exists
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);// bucket index
            int di = SearchInLL(key, bi);// data index

            if (di == -1) {// key doesn't exist
                return null;
            } else {// key exists
                Node data = buckets[bi].get(di);
                return data.value;
            }

        }

        public ArrayList<K> keyset() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {// bi
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {// di
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public static void main(String[] args) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("Ajay", 19);
            map.put("dany", 21);
            map.put("watson", 23);
            System.out.println(map);
            ArrayList<String> keys = map.keyset();
            for (int i = 0; i < keys.size(); i++) {
                System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
            }
            map.remove("Ajay");
            System.out.println(map.get("Ajay"));
        }

    }
}
