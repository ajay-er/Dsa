package rough;

public class BSTcode {
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static Node insert(int data, Node root) {
        if (root == null) {
            return new Node(data);
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

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    private static Node delete1(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data > key) {
            root.left = delete1(root.left, key);
        } else if (root.data < key) {
            root.right = delete1(root.right, key);
        } else {

            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }else{

            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete1(root.right, IS.data);
        }
    }
        return root;

    }

    private static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] nodes = { 5, 1, 2, 3, 4 };
        Node root = null;

        for (int i = 0; i < nodes.length; i++) {
            root = insert(nodes[i], root);
        }

        inOrder(root);

        System.out.println();

        // if (search(21, root)) {
        // System.out.println("found");
        // } else {
        // System.out.println("not found");
        // }

        root =  delete1(root, 5);

        System.out.println();

        inOrder(root);

    }

}
