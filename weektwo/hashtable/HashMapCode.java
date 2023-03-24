package hashtable;

import java.util.LinkedList;

public class HashMapCode {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;// link list count
        private int N; // bucket count
        private LinkedList<Node>[] buckets;

        HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }


        V get(K key){
            int bi = hashing(key);// bucket index
            int di = SearchInLL(key, bi);// data index

            if(di==-1){//key doesnt exist
                return null;
            }else{//key exist -- update
                return buckets[bi].get(di).value;
            }
        }

        void put(K key, V value) {
            int bi = hashing(key);// bucket index
            int di = SearchInLL(key, bi);// data index

            if(di==-1){//key doesnt exist
                buckets[bi].add(new Node(key, value));
                n++;
            }else{//key exist -- update
                buckets[bi].get(di).value = value;
            }
        }

        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if(ll.get(i).key==key){
                    return i;//data index
                }
            }
            return -1;
        }

        private int hashing(K key) {
            int value = hash(key);
            System.out.println(value);
            // int value = key.hashCode(); //232524 -1334555
            return Math.abs(value) % N;
        }

        private int hash(K key) {
            int hash = 0;
            String str = key.toString();
            for (int i = 0; i < buckets.length; i++) {
                hash = hash + 31 * str.charAt(i);
            }
            return hash;
        }
    }


    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Ajay", 23);
        map.put("Joel", 25);
        map.put("Kasi", 19);
        map.put("Ajay", 27);

        // System.out.println(map.get("Ajay"));
        // System.out.println("---> "+map.get("Joel"));
        System.out.println("---> "+map.get("Ajay"));
    }
}
