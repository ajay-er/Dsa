package revise;

import java.util.LinkedList;
import java.util.Queue;

public class Bt1 {
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

    static void inOrder(Node root) {
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

    static int countOfNode(Node root) {
        if (root == null) {
            return 0;
        }

        return countOfNode(root.left) + countOfNode(root.right) + 1;
    }

    static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
    }

    static int heightOfNode(Node root) {
        if (root == null) {
            return 0;
        }

        int left = heightOfNode(root.left);
        int right = heightOfNode(root.right);

        return Math.max(left, right) + 1;

    }

    static boolean isBstOrNot(Node root) {
        return bstCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean bstCheck(Node root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        if (root.data < minValue || root.data > maxValue) {
            return false;
        }
        return bstCheck(root.left, minValue, root.data - 1) && bstCheck(root.right, root.data + 1, maxValue);
    }

    static boolean isBTidentical(Node root, Node root2) {
        if (root == null && root2 == null) {
            return true;
        }

        if (root == null || root2 == null) {
            return false;
        }

        if (root.data != root2.data) {
            return false;
        }

        return isBTidentical(root.left, root2.left) && isBTidentical(root.right, root2.right);
    }

    public static void main(String[] args) {
        int[] nodes = { 4, 2, 1, -1, -1, 3, -1, -1, 7, -1, 9, -1, -1 };
        int[] node2 = { 4, 2, 12, -1, -1, 3, -1, -1, 7, -1, 9, -1, -1 };
        Node root2 = buildTree(node2);
        idx = -1;
        Node root = buildTree(nodes);
        // inOrder(root);
        // levelOrder(root);
        // System.out.println(countOfNode(root));
        // System.out.println(sumOfNodes(root));
        // System.out.println(heightOfNode(root));

        // System.out.println(isBstOrNot(root));

        System.out.println(isBTidentical(root, root2));
    }

}
