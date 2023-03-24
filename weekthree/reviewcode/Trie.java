package reviewcode;

public class Trie {

    class Node{
        Node children[];
        boolean endofWord;

        Node(){
            children = new Node[26];
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }

            endofWord = false;
        }
    }

    Node root = new Node();

    // void buildTrie(String key){
        
    //     for (int i = 0; i < key.length(); i++) {
    //         int idx = 
    //     }

    // }
}
