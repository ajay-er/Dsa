package revise;

public class Trie {
    static class Node {
        Node[] children;
        boolean endOfWord;

        Node() {
            children = new Node[26];
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            endOfWord = false;
        }
    }

    static Node root = new Node();

    private static void buildTrie(String word) {
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

    private static boolean search(String key) {
        Node curr = root;

        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }

            if (key.length() - 1 == i && curr.children[idx].endOfWord == true) {
                return true;
            }

            curr = curr.children[idx];
        }
        return false;
    }

    static void suggestionPrefix(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return;
            }

            curr = curr.children[idx];
        }

        findAllWords(curr, word);
    }

    private static void findAllWords(Node curr, String word) {
        if (curr.endOfWord) {
            System.out.println(word);
        }

        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                String newWord = word + (char) ('a' + i);
                findAllWords(curr.children[i], newWord);
            }
        }
    }

    static void remove(String word) {
        remove(root, word, 0);
    }

    private static Node remove(Node node, String word, int depth) {
        if (node == null) {
            return null;
        }

        if (depth == word.length()) {

            if (node.endOfWord) {
                node.endOfWord = false;
            }

            if (isEmpty(node)) {
                node = null;
            }

            return node;
        }

        int idx = word.charAt(depth) - 'a';
        node.children[idx] = remove(node.children[idx], word, depth+1);

        if(isEmpty(node) && node.endOfWord==false){
            node = null;
        }

        return node;

    }

    private static boolean isEmpty(Node node) {

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[] data = { "application", "app", "ajay", "apple", "aju" };
        for (int i = 0; i < data.length; i++) {
            buildTrie(data[i]);
        }

        remove("ajay");
        System.out.println(search("ajay"));

        // suggestionPrefix("ap");

    }

}
