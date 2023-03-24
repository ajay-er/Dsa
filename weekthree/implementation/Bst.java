package implementation;

import java.util.*;

public class Bst {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right =null;
        }
    }

    static boolean search(Node root,int data){
        if(root==null){
            return false;
        }

        if(root.data == data ){
            return true;
        }

        if(root.data > data){
            return search(root.left, data);
        }else{
            return search(root.right, data);
        }
    }

    static Node insert(int data,Node root){
        if(root == null){
            return root = new Node(data);
        }

        if(root.data > data){
            root.left = insert(data,root.left);
        }else{
            root.right = insert(data,root.right);
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

    static Node delete(int data,Node root){
        if(root==null){
            return null;
        }

        if(root.data < data){
            root.right = delete(data, root.right);
        }else if(root.data > data){
            root.left = delete(data, root.left);
        }else{
            //case 1 
            if(root.left==null && root.right==null){
                return null;
            }

            //case 2
            if(root.left==null){
                return root.right;
            }else if(root.right ==null){
                return root.left;
            }
            //case 3 

            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(IS.data, root.right);

        }
        return root;
    }

    private static Node inorderSuccessor(Node root) {
        while(root.left!=null){
             root = root.left;
        }
        return root;
    }

    static int closestValue(Node root , int key){
        int closest = root.data;

        while(root!=null){
            if(root.data==key){
                return root.data;
            }

            if(Math.abs(root.data - key) < Math.abs(closest-key)){
                closest = root.data;
            }

            if(root.data > key){
                root = root.left;
            }else{
                root = root.right;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int[] node = {4,3,2,1,7,8,12,9,10};
        Node root = null;
        for (int i = 0; i < node.length; i++) {
             root = insert(node[i],root);
        }

        inOrder(root);

        System.out.println();

        delete(1, root);

        inOrder(root);
        // System.out.println();

        // levelOrder(root);


    //    System.out.println( search(root, 12));



    }
}
