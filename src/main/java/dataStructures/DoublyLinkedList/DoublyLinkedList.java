package dataStructures.DoublyLinkedList;

import dataStructures.singlyLinkedList.LinkedList;

public class DoublyLinkedList {
//creating the properties of the Linked List
    static class Node
    {
        int data;  //stores the data
        Node next;  // stores the pointer to the next
        Node prev;  //stores a pointer to the previous node

        //creating a constructor for our node class to take in data
        public Node(int data){
            this.data = data;
        }
    }
    Node head;  //creating node property that would point to the head element of your LL
    Node tail;  //creating a node property to point to the tail element of our LL
    int size = 0; //default size being zero to denote and empty ll

    //creating and add method to add to my doubly linked list
    public void add(int data){
        //1. create a new node to add to the linked list
        Node newNode =  new Node(data);
        //2. check if your list is empty or not

        if(head == null)
        {
            head = newNode;
            tail = newNode;
        } else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    //adding to an index in a linked list
    public void  add(int data, int index){
        //checking if the right index was giving
        if(index < 0 || index >  (size-1))
        {
            System.out.println("Invalid index");
            return;
        }
        //creating a node to be inserted
        Node newNode = new Node(data);
        Node curr = findNode(index); //using the helper function to find a node
        Node previousNode = curr.prev;  //setting a node variable to hold currents node previous element
        if(curr == head){
             newNode.next = head;  //inserting at the zero index position
            head.prev = newNode;   //heads previous pointer points to the new node
            head =  newNode;
        }else if (curr == tail)
        {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        else {
            previousNode.next =  newNode;  //setting the previous node to the newNode
            newNode.prev = previousNode;  //setting the new nodes previous to the previous node
            newNode.next = curr;     //new nodes next node to the current node
            curr.prev = newNode;     //current previous node to the new node
        }

        size++; //increasing the size
    }

    public int get(int index) {
        if (index < 0 || index > (size - 1)) {
            System.out.println("Invalid index");
            return Integer.MIN_VALUE;
        }
        Node target = findNode(index);
         return target.data;
    }

    public void remove(int index){
        if (index < 0 || index > (size - 1)) {
            System.out.println("Invalid index"); //verifying the index method
            return;
        }
        Node current = findNode(index);  //using the find node method to find the target node
        Node previousNode = current.prev; //finding the previous node of the target node;
        Node nextNode = current.next;    //finding the current node

        previousNode.next = nextNode;  //make the next and previous node next point to the nextNode
        nextNode.prev = previousNode;  //make the next node's previous point to the previous node
        size--; //decrease the size;
    }

    //utility function for find a node given the index
private  Node findNode(int index){
    int mid = (size - 1) / 2;  //create a mid-variable
    if (mid > index) {    //if your index is greater than the mid-variable then search the forward direction
      return findForward(index);
    }
     return findReverse(index);

}

    //traversing in the forward direction
    private  Node findForward(int index ){
       int i = 0;
       Node currentNode = head;
            while (currentNode != null && i != index)
            {
                currentNode = currentNode.next;
                i++;
            }
            return currentNode;
    }


    //traversing in the reverse  direction
    private  Node findReverse(int index ){
        int i = size -1 ;
        Node currentNode = tail;
        while (currentNode!= null && i != index)
        {
            currentNode = currentNode.prev;
            i--;
        }
        return currentNode;
    }
    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("[");
        Node curr = head;
        while (curr != null) {
            buf.append(curr.data).append("-");
            curr = curr.next;
        }
        if (buf.length() > 1) {
            buf.deleteCharAt(buf.length() - 1);
//            buf.deleteCharAt(buf.length() - 1);
        }
        buf.append("]");
        return buf.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList ddl = new DoublyLinkedList();
        ddl.add(5);
        ddl.add(7);
        ddl.add(6);
        ddl.add(40,1);
        ddl.add(8);
        ddl.add(9);
        ddl.add(79,0);
        ddl.add(90,6);
        System.out.println(ddl);
        System.out.println("printing data from the second position ----> " + ddl.get(2));
        System.out.println("removing the a node at  index position 2");
        ddl.remove(2);
        System.out.println(ddl);

    }


}
