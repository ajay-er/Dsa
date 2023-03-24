package tree;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeYt {

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

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static int heightOfNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftHeight = heightOfNodes(root.left);
        int rightHeight = heightOfNodes(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

   public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNode = sumOfNodes(root.left);
        int rightNode = sumOfNodes(root.right);

        return leftNode + rightNode + root.data;
    }

    public static int countOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNode = countOfNodes(root.left);
        int rightNode = countOfNodes(root.right);

        return leftNode + rightNode + 1;
    }


    public static int diameterOfNodes(Node root){//o(n^2)
        if(root== null){
            return 0;
        }
        int diam1 = diameterOfNodes(root.left);
        int diam2 = diameterOfNodes(root.right);
        int diam3 = heightOfNodes(root.left) + heightOfNodes(root.right) + 1;

        return Math.max(Math.max(diam1, diam2), diam3);
    }


    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOreder(Node root) {
        if (root == null) {
            return;
        }

        inOreder(root.left);
        System.out.print(root.data + " ");
        inOreder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);

        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currentNode = q.remove();
            if (currentNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }

            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
        }
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

    public static void main(String[] args) {
        // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        
        int nodes[] = { 4,2,1,-1,-1,3,-1,-1,5,-1,2,-1,-1 };

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);

        // preOrder(root);
        inOreder(root);
        // postOrder(root);
        // levelOrder(root);

        // int count = countOfNodes(root);
        // System.out.println(count);

        // System.out.println(sumOfNodes(root));

        // System.out.println(heightOfNodes(root));

        // System.out.println(diameterOfNodes(root));

        System.out.println(isBSTorNot(root));

    }
}
