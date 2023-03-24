package rough;

public class BST2 {
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(int data, Node root) {
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

    public static boolean search(int data, Node root) {
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

    public static Node delete(int data, Node root) {
        if (root == null) {
            return null;
        }

        if (root.data > data) {
            root.left = delete(data, root.left);
        } else if (root.data < data) {
            root.right = delete(data, root.right);
        } else {
            // key equals

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
        int[] values = { 2, 5, 6, 23, 7 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(values[i], root);
        }

        inOrder(root);
        // System.out.println(search(23, root));
        System.out.println();

        root = delete(23, root);

        inOrder(root);
    }
}
