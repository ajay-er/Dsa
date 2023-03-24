package rough;

public class TrieCode {

    static class Node {
        private Node[] children;
        private boolean endOfWord;

        Node() {
            children = new Node[26];
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            endOfWord = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            if (word.length() - 1 == i) {
                curr.children[idx].endOfWord = true;
            }

            curr = curr.children[idx];
        }
    }

    
    public static boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }

            if (word.length() - 1 == i && curr.children[idx].endOfWord == false) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }



    private static void findWordsWithPrefix(String key) {
        Node curr = root;
        
        for (int i = 0; i < key.length(); i++) {

            int idx = key.charAt(i) - 'a';

            if(curr.children[idx]==null){
                return;
            }
            curr = curr.children[idx];
        }
        findAllWordsInTree(curr,key);
    }

    
    private static void findAllWordsInTree(Node curr, String key) {

    }


    public static void main(String[] args) {
        String[] words = { "the", "their", "an", "a", "are", "no","there" };

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("the"));
        System.out.println(search("an"));
        System.out.println(search("a"));
        System.out.println(search("ab"));

        System.out.println();

        findWordsWithPrefix("th");
    }
}
