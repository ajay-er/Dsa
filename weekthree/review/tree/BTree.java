package tree;


import java.util.LinkedList;
import java.util.Queue;

public class BTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if(idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void inOrderTraversal(Node root) {
            if (root == null) {
                return;
            }

            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }

        public static void preOrderTraversal(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        public static void postOrderTraversal(Node root) {
            if (root == null) {
                return;
            }

            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");

        }

        public static void levelOrderTraversal(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }

                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }

            }
        }

        public static int countOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            return countOfNodes(root.left) + countOfNodes(root.right) + 1;

        }

        public static int sumOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;

        }

        public static int heightOfTree(Node root) {
            if (root == null) {
                return 0;
            }

            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        public static int diameter(Node root) {
            if (root == null) {
                return 0;
            }

            int diam1 = diameter(root.left);
            int diam2 = diameter(root.right);
            int diam3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
            return Math.max(diam3, Math.max(diam2, diam1));
        }

        public static void main(String[] args) {
            int nodes[] = { 1, 2, 4, -1, -1, 5 ,-1, -1, 3, -1, 6, -1, -1 };
            BinaryTree tree = new BinaryTree();
            Node root = tree.buildTree(nodes);
            // System.out.println(root.data);
            // postOrderTraversal(root);
            // levelOrderTraversal(root);

            // System.out.println(countOfNodes(root));

            // System.out.println(sumOfNodes(root));

            // System.out.println(heightOfTree(root));

            // System.out.println(diameter(root));

            
        }
    }

}
