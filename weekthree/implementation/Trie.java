package implementation;

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

    static void buildTrie(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            if (i == word.length() - 1) {
                curr.children[idx].endOfWord = true;
            }
            curr = curr.children[idx];
        }
    }

    static boolean search(String key) {
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

    static void suggestionPrefix(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {

            int idx = prefix.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return;
            }

            curr = curr.children[idx];
        }

        findPrefixWords(prefix, curr);
    }

    private static void findPrefixWords(String word, Node curr) {
        if (curr.endOfWord) {
            System.out.println(word);
        }

        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                String newWord = word + (char) ('a' + i);
                findPrefixWords(newWord, curr.children[i]);
            }
        }
    }

    static void remove(String word) {
        remove(word, root, 0);
    }

    private static Node remove(String word, Node curr, int depth) {
        if (curr == null) {
            return null;
        }

        if (depth == word.length()) {

            if (curr.endOfWord) {
                curr.endOfWord = false;
            }

            if (isEmpty(curr)) {
                curr = null;
            }

            return curr;
        }

        int idx = word.charAt(depth) - 'a';
        curr.children[idx] = remove(word, curr.children[idx], depth + 1);

        if (isEmpty(curr) && curr.endOfWord == false) {
            curr = null;
        }

        return curr;

    }

    static boolean isEmpty(Node curr) {
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] names = { "the", "thor", "there", "thread", "thought", "an", "only", "auto" };

        for (int i = 0; i < names.length; i++) {
            buildTrie(names[i]);
        }

        // System.out.println(search("thor"));
        // suggestionPrefix("a");
    }

}
