package revise;

public class Bst {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node insert(int data, Node root) {
        if (root == null) {
            return root = new Node(data);
        }

        if (root.data > data) {
            root.left = insert(data, root.left);
        } else {
            root.right = insert(data, root.right);
        }
        return root;
    }

    static boolean search(int data, Node root) {
        if (root == null) {
            return false;
        }

        if (root.data == data) {
            return true;
        }

        if (root.data > data) {
            return search(data, root.left);
        } else {
            return search(data, root.right);
        }
    }

    static Node delete(int data, Node root) {
        if (root == null) {
            return null;
        }

        if (root.data > data) {
            root.left = delete(data, root.left);
        } else if (root.data < data) {
            root.right = delete(data, root.right);
        } else {

            // case 1
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3

            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(IS.data, root.right);
        }
        return root;
    }

    private static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    public static void main(String[] args) {
        int[] node = { 2, 62, 3, 63, 34 };
        Node root = null;
        for (int i = 0; i < node.length; i++) {
            root = insert(node[i], root);
        }

        inOrder(root);
        // System.out.println(search(3, root));
        root = delete(3, root);
        System.out.println();
        inOrder(root);
    }

}
