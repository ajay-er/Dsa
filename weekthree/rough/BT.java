package rough;

import java.util.LinkedList;
import java.util.Queue;

public class BT {
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
        }
    }

    static class Tree {

        static int idx = -1;

        public static Node buildcTree(int[] nodes) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node node = new Node(nodes[idx]);
            node.left = buildcTree(nodes);
            node.right = buildcTree(nodes);
            
            return node;
        }

        public static void inOreder(Node root) {
            if (root == null) {
                return;
            }

            inOreder(root.left);
            System.out.print(root.data + " --> ");
            inOreder(root.right);
        }

        public static void levelOrder(Node root) {
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
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Tree tree = new Tree();
        Node root = tree.buildcTree(nodes);

        tree.inOreder(root);

        // tree.levelOrder(root);
    }
}
