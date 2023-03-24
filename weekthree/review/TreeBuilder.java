// package rough;

// class TreeNode {
//     private int value;
//     private TreeNode left;
//     private TreeNode right;

//     public TreeNode(int value) {
//         this.value = value;
//         this.left = null;
//         this.right = null;
//     }

//     public void setLeft(TreeNode left) {
//         this.left = left;
//     }

//     public void setRight(TreeNode right) {
//         this.right = right;
//     }

//     public int getValue() {
//         return value;
//     }

//     public TreeNode getLeft() {
//         return left;
//     }

//     public TreeNode getRight() {
//         return right;
//     }
// }

// public class TreeBuilder {
//     public static void main(String[] args) {
//         // Create a root node
//         TreeNode root = new TreeNode(1);

//         // Create left and right child nodes
//         TreeNode leftChild = new TreeNode(2);
//         TreeNode rightChild = new TreeNode(3);

//         // Set left and right child nodes of the root node
//         root.setLeft(leftChild);
//         root.setRight(rightChild);

//         // Create left and right child nodes of the left child node
//         TreeNode leftLeftChild = new TreeNode(4);
//         TreeNode leftRightChild = new TreeNode(5);

//         // Set left and right child nodes of the left child node
//         leftChild.setLeft(leftLeftChild);
//         leftChild.setRight(leftRightChild);

//         // Create left and right child nodes of the right child node
//         TreeNode rightLeftChild = new TreeNode(6);
//         TreeNode rightRightChild = new TreeNode(7);

//         // Set left and right child nodes of the right child node
//         rightChild.setLeft(rightLeftChild);
//         rightChild.setRight(rightRightChild);

//         System.out.println(root.getValue());
//     }
// }
