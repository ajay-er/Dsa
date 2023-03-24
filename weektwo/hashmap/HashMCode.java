package hashmap;

import java.util.LinkedList;

public class HashMCode {
     static class HashMap<K, V> {
          private class Node {
               K key;
               V value;

               public Node(K key, V value) {
                    this.key = key;
                    this.value = value;
               }
          }

          private int n;// number of linkedlist
          private int N;// number of buckets
          private LinkedList<Node>[] buckets;// array of linked lists

          @SuppressWarnings("unchecked")
          HashMap() {
               this.N = 4;
               buckets = new LinkedList[4];
               for (int i = 0; i < N; i++) {
                    this.buckets[i] = new LinkedList<>();
               }
          }

          private int searchDataIndex(K key, int bi) {
               LinkedList<Node> ll = buckets[bi];
               for (int i = 0; i < ll.size(); i++) {
                    if (ll.get(i).key == key) {
                         return i;// data index;
                    }
               }
               return -1;
          }

          private int hashFunction(K key) {
               int val = hashF(key);
               return Math.abs(val) % N;
          }

          private int hashF(K key) {
               int hash = 0;
               String s = key.toString();
               for (int i = 0; i < s.length(); i++) {
                    hash = (hash * 31 + s.charAt(i));
               }
               System.out.println(hash);
               return hash;
          }

          void put(K key, V value) {
               int bi = hashFunction(key);
               int di = searchDataIndex(key, bi);

               if (di == -1) {
                    buckets[bi].add(new Node(key, value));
                    n++;
               } else {
                    buckets[bi].get(di).value = value;
               }

               double lambda = (double) n / N;
               if (lambda > 2.0) {
                    rehash();
               }
          }

          private void rehash() {
               LinkedList<Node> oldBucket[] = buckets;
               buckets = new LinkedList[N * 2];

               for (int i = 0; i < buckets.length; i++) {
                    buckets[i] = new LinkedList<>();
               }
               for (int i = 0; i < oldBucket.length; i++) {
                    LinkedList<Node> ll = buckets[i];
                    for (int j = 0; j < ll.size(); j++) {
                         Node node = ll.get(j);
                         put(node.key, node.value);
                    }
               }

          }

          boolean isEmpty() {
               return n == 0;
          }

          boolean containskey(K key) {
               int bi = hashFunction(key);
               int di = searchDataIndex(key, bi);

               if (di == -1) {
                    return false;
               } else {
                    return true;
               }
          }

          V remove(K key) {
               int bi = hashFunction(key);
               int di = searchDataIndex(key, bi);

               if (di == -1) {
                    return null;
               } else {
                    Node node = buckets[bi].remove(di);
                    n--;
                    return node.value;
               }
          }

          V get(K key) {
               int bi = hashFunction(key);
               int di = searchDataIndex(key, bi);

               if (di == -1) {
                    return null;
               } else {
                    return buckets[bi].get(di).value;
               }
          }

          void display() {
               for (int i = 0; i < N; i++) {
                    LinkedList<Node> ll = buckets[i];
                    for (Node node : ll) {
                         System.out.println(node.key + ":" + node.value);
                    }
               }
          }

     }

     public static void main(String[] args) {
          HashMap<String, Integer> map = new HashMap<>();
          map.put("arun", 23);
          map.put("joel", 25);
          map.put("kasi", 19);
          map.put("goku", 22);
          map.display();

          System.out.println(map.get("joel"));
          System.out.println(map.containskey("arun"));

     }

}

// //hashfunction
// class hashingFunction{
// int hashComplex(String input){
// int hash = 0;
// for (int i = 0; i < input.length(); i++) {
// hash = (hash * 31 + input.charAt(i))%1000000007;
// }
// return hash;
// }
// }

// class hashF{
// static int hashingFunction(String key){
// int hash = 0;
// for (int i = 0; i <key.length(); i++) {
// hash =( hash * 31 + key.charAt(i))%1000000007;
// }
// return hash;
// }

// public static void main(String[] args) {
// int key = hashingFunction("ahay");
// System.out.println(key);
// }

// }