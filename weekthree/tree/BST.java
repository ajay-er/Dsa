package tree;


public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

     class BSTnew {
        
        public static boolean isIdentical(Node root1, Node root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null) {
                return false;
            }
            if (root1.data != root2.data) {
                return false;
            }
            return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
        }


    public static boolean isBSTorNot(Node root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTHelper(Node root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.data < minValue || root.data > maxValue) {
            return false;
        }
        return isBSTHelper(root.left, minValue, root.data - 1) && isBSTHelper(root.right, root.data + 1, maxValue);
    }

    public static void printInRange(Node root, int X, int Y) {
        if (root == null) {
            return;
        }
        if (root.data >= X && root.data <= Y) {
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        } else if (root.data >= Y) {
            printInRange(root.left, X, Y);
        } else {
            printInRange(root.right, X, Y);
        }
    }

    static Node prev = null;

    public static boolean isBST(Node root) {
        if (root != null) {

            if (!isBST(root.left)) {
                return false;
            }

            if (prev != null && root.data <= prev.data) {
                return false;
            }

            prev = root;

            return isBST(root.right);
        }
        return true;
    }

    public static int closestValue(Node root, int target) {
        int closest = root.data;

        while (root != null) {
            if (root.data == target) {
                return root.data;
            }

            if (Math.abs(root.data - target) < Math.abs(closest - target)) {
                closest = root.data;
            }

            if (root.data > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return closest;
    }

    public static Node insert(int value, Node root) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (root.data > value) {
            // * left subtree
            root.left = insert(value, root.left);
        } else {
            root.right = insert(value, root.right);
        }
        return root;
    }

    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int val) {// * O(H)
        if (root == null) {
            return false;
        }

        if (root.data == val) {
            return true;
        }

        if (root.data > val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    public static Node delete(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        } else {// root.data == val
                // case 1
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2
            if (root.left == null) {
                return root.right;
            }

            else if (root.right == null) {
                return root.left;
            }

            // case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
     }
    }

    public static void main(String[] args) {
        int[] values = { 10,23,21,8,20,12,8,16 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = BSTnew.insert(values[i], root);
        }

        BSTnew.inOrder(root);

        // if (search(root, 22)) {
        // System.out.println("Found");
        // } else {
        // System.out.println("Not found");
        // }

        // delete(root, 7);
        System.out.println();
        BSTnew.inOrder(root);

        // System.out.println();
        // printInRange(root, 2, 5);

        int val =BSTnew.closestValue(root, 14);
        System.out.println();
        System.out.println(val);

        // System.out.println(isBST(root));

        // System.out.println(BSTnew.isBSTorNot(root));

    }
}
