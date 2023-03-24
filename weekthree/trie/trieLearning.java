package trie;

public class trieLearning {
    static class Node {
        private Node[] children;
        private boolean endOfWord;

        public Node() {
            children = new Node[26];// a to z
            
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }

            endOfWord = false;
        }
    }

    static Node root = new Node();
    // it took O(L) to take insert a word into trie. L means length of the word.

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {// O(L)
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                // add new node
                curr.children[idx] = new Node();
            }
            if (i == word.length() - 1) {
                curr.children[idx].endOfWord = true;
            }
            curr = curr.children[idx];
        }
    }

    
    // public static void findWordsWithPrefix(String prefix) {
    //     Node curr = root;
        
    //     StringBuilder sb = new StringBuilder(prefix);

    //     for (int i = 0; i < prefix.length(); i++) {
    //         int idx = prefix.charAt(i) - 'a';

    //         if (curr.children[idx] == null) {
    //             return;
    //         }

    //         curr = curr.children[idx];
    //     }

    //     findAllWords(curr, sb);
    // }

    // private static void findAllWords(Node node, StringBuilder sb) {
    //     if (node.endOfWord) {
    //         System.out.println(sb.toString());
    //     }

    //     for (int i = 0; i < node.children.length; i++) {
    //         if (node.children[i] != null) {
    //             sb.append((char) ('a' + i));
    //             findAllWords(node.children[i], sb);
    //             sb.deleteCharAt(sb.length() - 1);
    //         }
    //     }
    // }



public static void findWordsWithPrefix(String prefix) {
        Node curr = root;
        String word = prefix;
    
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            
            if (curr.children[idx] == null) {
                return;
            }
    
            curr = curr.children[idx];
        }
    
        findAllWords(curr, word);
    }
    
    private static void findAllWords(Node node, String word) {
        if (node.endOfWord) {
            System.out.println(word);
        }
    
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                String newWord = word + (char) ('a' + i);
                findAllWords(node.children[i], newWord);
            }
        }
    }
    public static boolean search(String key) {
        // O(L) ===> L is length of the word
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }
            if (i == key.length() - 1 && curr.children[idx].endOfWord == false) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;

    }

    static boolean isEmpty(Node root)
    {
        for (int i = 0; i < 26; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }


private static void remove(String key){
    remove(root, key, 0);
}

 // Recursive function to delete a key from given Trie
 private static Node remove(Node root, String key, int depth)
 {
     // If tree is empty
     if (root == null)
         return null;

     // If last character of key is being processed
     if (depth == key.length()) {

         // This node is no more end of word after
         // removal of given key
         if (root.endOfWord)
             root.endOfWord = false;

         // If given is not prefix of any other word
         if (isEmpty(root)) {
             root = null;
         }

         return root;
     }

     // If not last character, recur for the child
     // obtained using ASCII value
     int index = key.charAt(depth) - 'a';
     root.children[index] = remove(root.children[index], key, depth + 1);

     // If root does not have any child (its only child got
     // deleted), and it is not end of another word.
     if (isEmpty(root) && root.endOfWord == false){
         root = null;
     }

     return root;
 }




    // public  static void delete(String word) {
    //     delete(root, word, 0);
    // }
    
    // private static boolean delete(Node node, String word, int index) {
    //     if (index == word.length()) {
    //         if (!node.endOfWord) {
    //             return false; // Word not found
    //         }
    //         node.endOfWord = false; // Mark the end of the word as deleted
    //         return isEmptyNode(node); // Return true if the node has no children and is not the root
    //     }
    //     int idx = word.charAt(index) - 'a';
    //     Node child = node.children[idx];
    //     if (child == null) {
    //         return false; // Word not found
    //     }
    //     boolean shouldDeleteChild = delete(child, word, index + 1);
    //     if (shouldDeleteChild) {
    //         node.children[idx] = null;
    //         return isEmptyNode(node); // Return true if the node has no children and is not the root
    //     }
    //     return false;
    // }
    
    // private static  boolean isEmptyNode(Node node) {
    //     for (Node child : node.children) {
    //         if (child != null) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    

    public static void main(String[] args) {
        String words[] = {"application","apple","ajay" ,"app","aju","not","onl"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("ajay"));// t
        System.out.println(search("sajay"));// f
        System.out.println(search("an"));// f

        System.out.println();

        remove("app");

        System.out.println();

        System.out.println(search("app"));
        System.out.println(search("application"));

        findWordsWithPrefix("a");
        
    }
}





    