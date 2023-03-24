package implementation;

import java.util.LinkedList;
import java.util.Queue;

public class Bt {
    static class Node {
        Node right;
        Node left;
        int data;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static int idx = -1;

    static Node buildTree(int[] nodes) {
        idx++;

        if (nodes[idx] == -1) {
            return null;
        }

        Node node = new Node(nodes[idx]);
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    private static void inOrder(Node root) {

        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

    }

    static boolean isBSTorNot(Node root) {
        return bstChecker(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean bstChecker(Node root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        if (root.data < minValue || root.data > maxValue) {
            return false;
        }

        return bstChecker(root.left, minValue, root.data - 1) && bstChecker(root.right, root.data + 1, maxValue);
    }

    static boolean isBTidentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }

        return isBTidentical(root1.left, root2.left) && isBTidentical(root1.right, root2.right);

    }

    static int countOfNode(Node root) {
        if (root == null) {
            return 0;
        }

        return countOfNode(root.left) + countOfNode(root.right) + 1;
    }


    static int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }

        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
    }

    static int heightOfNodes(Node root){
        if(root==null){
            return 0;
        }

        int left = heightOfNodes(root.left);
        int right = heightOfNodes(root.right);

        return Math.max(left, right)+1;
    }

    public static void main(String[] args) {
        int[] nodes = { 2, 1, 6, -1, -1, 22, -1, -1, 69, -1, 234, -1, -1 };
        // int[] nodes = { 4,2,1,-1,-1,3,-1,-1,7,6,-1,-1,9,-1,-1 };
        // int[] nodes2 = { 4,2,1,-1,-1,3,-1,-1,7,6,-1,-1,9,-1,-1 };

        Node root = buildTree(nodes);

        idx = -1;
        // Node root2 = buildTree(nodes2);

        // inOrder(root);

        // levelOrder(root);

        // System.out.println(isBSTorNot(root));

        // System.out.println(isBTidentical(root, root2));

        // System.out.println(countOfNode(root));

        // System.out.println(sumOfNodes(root));
    }
}
