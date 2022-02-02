package dataStructures.BinarySearchTree;

public class BinarySearchTree {

    private class Node{
        int data;
        Node right;
        Node left;

        public Node(int data){
            this.data = data;
        }

    }

    Node root;    //a property of the binary search tree class

    //add method of the binary tree
    public void add(int data){
        root = addToNode(root, data);     //adding using the recursion method
    }

    private Node addToNode(Node root, int data)  //a method that adds to the node
    {
        if(root == null){           //if the root is null create a new root and append the data
            root = new Node(data);
            return root;
        }
        if(data < root.data){
            root.left = addToNode(root.left, data);
        } else if(data > root.data){
            root.right = addToNode(root.right, data);
        }
        return root;
    }
    //creating a traversal order of searching the root
    public void inOrder(){
        inOrderByNode(root);
        System.out.println();
    }

    private void inOrderByNode(Node root) {
        if(root != null){
            inOrderByNode(root.left);
            System.out.println(root.data+" ");
            inOrderByNode(root.right);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
    }
}
