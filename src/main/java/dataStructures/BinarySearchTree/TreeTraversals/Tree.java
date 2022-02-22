package dataStructures.BinarySearchTree.TreeTraversals;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public static void main(String[] args) {
        Node<String> A = new Node<String>("A");
        Node<String> B = new Node<String>("B");
        Node<String> C = new Node<String>("C");
        Node<String> D = new Node<String>("D");
        Node<String> E = new Node<String>("E");
        Node<String> F = new Node<String>("F");
        Node<String> G = new Node<String>("G");
        Node<String> H = new Node<String>("H");
        Node<String> I = new Node<String>("I");
        Node<String> J = new Node<String>("J");
        Node<String> K = new Node<String>("K");

        Node<String> root = A;
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = H;
        D.right = I;
        E.left = J;
        C.left = F;
        C.right = G;
        G.left = K;

        System.out.println("--Pre order Traversal------");
        preOrderTraversal(A);  //expected: A B D H I E J C F G K
        System.out.println(" ");
        System.out.println("--In-order Traversal------");
        inOrderTraversal(A);  //expected: H D I B J E A F C K G
        System.out.println(" ");
        System.out.println("--PostOrder Traversal------");
        PostOderTraversal(A);  //expected: : H I D J E B F K G C A
        System.out.println(" ");
        System.out.println("--levelOrder Traversal------");
        levelOrderTraversal(A);  //expected:  A B C D E F G H I J K
    }

    /**
     * PreOder Traversal method taking a Node in as a parameter and making the following operations
     * //Display data at the node
     * //Calling preOrderTraverse for the left node
     * //Calling preOrderTraverse for the right node
     */
    public static <T> void preOrderTraversal(Node<T> node) {
        if (node == null){
            return;
        }
        System.out.print(node.data + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
    }

    /**
     * Inorder traversal takes a node as a parameter and make the following operations
     * //Call inorder Traversal at the leftNode
     * //Display the data at the node
     * //call inOrder Traversal at the right node
     */
    public static <T> void inOrderTraversal(Node<T> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + " ");
            inOrderTraversal(node.right);
        }

    }

    /**
     * Post-Order traversal takes a node as a parameter and make the following operations
     * //Call Post-Order Traversal at the leftNode
     * //Display the data at the node
     * //call Post-Order Traversal at the right node
     */
    public static <T> void PostOderTraversal(Node<T> node) {
        if (node != null) {
            PostOderTraversal(node.left);
            PostOderTraversal(node.right);
            System.out.print(node.data + " ");
        }

    }

    /**
     * implementing the level order traversal in a binary three we need to use the
     * Queue data structure to implement the data structure
     */


    public static <T> void levelOrderTraversal(Node<T> node){
        if (node == null){
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            Node <T> temp = queue.poll();
            System.out.print(temp.data + " ");

            if(temp.left != null){
                queue.offer(temp.left);
            }


            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }
}

