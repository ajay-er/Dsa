// package hashmap;

// import java.util.LinkedList;

// public class HashtableCode {
//     static class HashMap<K, V> {
//         private class Node {
//             K key;
//             V value;

//             Node(K key, V value) {
//                 this.key = key;
//                 this.value = value;
//             }
//         }

//         private int n;// number linked list
//         private int N; // number of buckets
//         private LinkedList<Node>[] buckets;

//         HashMap() {
//             this.N = 4;
//             this.buckets = new LinkedList[N];
//             for (int i = 0; i < buckets.length; i++) {
//                 buckets[i] = new LinkedList<>();
//             }
//         }

//         void put(K key,V value){
//             int bi = hashF(key);
//             // int di = SearchInLL(key,bi);
//         }

//         private int hashF(K key) {
//             int hash =0;
//             String str = key.toString();
//             for (int i = 0; i < buckets.length; i++) {
//                 hash = hash *  31 + str.charAt(i);
//             }
//             return hash;
//         }
//     }
// }