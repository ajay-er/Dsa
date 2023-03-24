package revise;

import java.util.LinkedList;
import java.util.Queue;

public class Bt {

    static class Node {
        int data;
        Node left;
        Node right;

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

    static void levelOrder(Node root){
        if(root==null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                   q.add(curr.right);
                }
            }
        }
    }

    static boolean isBSTorNot(Node root){
        return checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private static boolean checkBST(Node root, int minValue, int maxValue) {
       if(root==null){
         return true;
       }

       if(root.data < minValue || root.data > maxValue){
            return false;
       }

       return checkBST(root.left, minValue, root.data - 1) && checkBST(root.right, root.data + 1 , maxValue);
    }


    static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;

    }


    static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = {4,2,1,-1,-1,5,-1,-1,18,-1,69,-1,-1};
        Node  root = buildTree(nodes);
        // inOrder(root);
        levelOrder(root);

        System.out.println(isBSTorNot(root));

        System.out.println();
        System.out.println(sumOfNodes(root));
    }

}