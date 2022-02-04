package dataStructures.BinarySearchTree;
class Node{
    int data;
    Node right;
    Node left;

    public Node(int data){
        this.data = data;
    }

}
public class BinarySearchTree {

    TreeDiagram treeDiagram;
    Node root;    //a property of the binary search tree class
    public BinarySearchTree(){
        this.treeDiagram = new TreeDiagram();
    }
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
  //removing a node from a binary search tree
    public void remove(int data){
        root = removeNode(root,data);   //a recursive function that removes data from the tree
    }

    private Node removeNode(Node root, int data) {
        if (root == null) {
            return root;
        }
            if (data < root.data) {
                root.left = removeNode(root.left, data);
            } else if (data > root.data) {
                root.right = removeNode(root.right, data);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    int minValue = findMinValue(root.right);
                System.out.println("right side minimum value : " + minValue) ;
                root.data = minValue; //update minimum value with the target node
                root.right = removeNode(root.right, minValue); //remove the minimum value from the right side
//
//

                }
        }
        return root;
    }


//
    private int findMinValue(Node root) {
        int minVal = root.data;
        root = root.left;
        while (root != null){
            minVal = root.data;
            root = root.left;
        }
        return minVal;
    }

    //creating a traversal order of searching the root
    public void inOrder(){
        if(root != null){
            System.out.print("Inorder traversal: ");
        }
        inOrderByNode(root);
        System.out.println();
        treeDiagram.print(root);
    }

    private void inOrderByNode(Node root) {
        if(root != null){
            inOrderByNode(root.left);
            System.out.print(root.data+" ");
            inOrderByNode(root.right);
        }
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(20);
        bst.add(30);
        bst.add(10);
        bst.add(5);
        bst.add(16);
        bst.add(24);
        bst.inOrder();
        bst.remove(20);
        bst.inOrder();
        bst.remove(24);
        bst.inOrder();




    }
}
