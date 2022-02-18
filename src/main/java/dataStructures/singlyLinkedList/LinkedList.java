package dataStructures.singlyLinkedList;

public class LinkedList {
    //create a mini class for the micking an node

   static class Node {
        int data;  //creating the placeholder of data in the node
        Node next; //where the pointer information is stored
        public Node(int data){
            this.data = data;
        }       //creating a parameterised constructor to create a node
    }

    //creating the head and tail of a linked list
    Node head;
    Node tail;
    int size = 0; //creating a variable to keep the size of a node

    //creating a method to add to a linked list
    //if the head is null meaning there is no data in the linked List then, create a new head node
    // and append to the linked list.
    //else append the created node to the tail element of the linked list

    public void add(int data) {
        Node newNode = new Node(data); //Instantiating a new node here
            if(head == null ){
                head = newNode;  //head would be assigned to the new node
                tail = newNode;  //tail would also be assigned to the only node in the linked list
            }else{
                tail.next = newNode;
                tail = newNode;
            }
            //increase the size of the linked list now that there is data in there
        size++;
        System.out.println(this);
    }

    //adding a node at a particular index
    public void add(int data, int index){
        if(index < 0 || index > (size-1)){      //if the user passed in a wrong index
            System.out.println("index out of range ");
            return;
        }
        //creating a temporal node to help you insert and track its always points to the head element
        Node currentNode = head;
        Node prev = null;
        int i = 0;   //creating a variable to track the element
         //when inserting make sure the current node is not null and the tracker variable is not equal to the index
        //passed
        while(currentNode != null && i != index){
                 prev = currentNode;
                currentNode = currentNode.next;
                i++;
        }
        //if the while condition of the while loop breaks out. we insert to the first position
        //by creating a new node and assigning it to the position and increase the size
        Node newNode = new Node(data);
        if(prev == null) //inserting at the first position
        {
            newNode.next = head;
            head = newNode;
        } else {  //inserting at a position in the linked list
            prev.next = newNode;
            newNode.next = currentNode;
        }
        size++;
        System.out.println(this);
    }

    //removing from the list
    public void remove(int index){
        if(index < 0 || index > (size-1)){
            System.out.println("index out of range ");
            return;
        }
        Node currentNode = head;
        Node prev = null;
        int i = 0;

        while (currentNode != null && i != index){
            prev = currentNode;
            currentNode = currentNode.next;
            i++;
        }
        if(prev == null) {
            head = head.next;
        }else {  //inserting at a position in the linked list
            prev.next = currentNode.next;
        }
        if(currentNode == tail){  //removing from the last position
            tail = prev;
        }
        currentNode.next = null;
        size--;
        System.out.println(this);

    }
    //getting an element by index
    public int get (int index){
        Node currentNode = head;
        int i = 0;

        if(index < 0 || index > (size - 1)) {
            System.out.println("index is out of range ");
            return Integer.MIN_VALUE;
        }
        while (currentNode != null && i != index){
            currentNode = currentNode.next;
            i++;
        }
        return currentNode.data;


    }




    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
		buf.append("[");
        Node curr = head;
        while (curr != null) {
            buf.append(curr.data).append("->");
            curr = curr.next;
        }
        if (buf.length() > 0) {
            buf.deleteCharAt(buf.length() - 1);
//            buf.deleteCharAt(buf.length() - 1);
        }
		buf.append("]");
        return buf.toString();
    }


    public static void main(String[] args) {
   LinkedList linkedList = new LinkedList();
   linkedList.add(10);
        linkedList.add(40);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(90,0);
        linkedList.add(100,3);
        System.out.println(linkedList.get(3));;
        System.out.println("about to remove  data at the first position");
        linkedList.remove(0);
        System.out.println("about to remove  data at the second position");
        linkedList.remove(1);
        System.out.println("about to remove  data at the second position");
        System.out.println("2nd index data:" + linkedList.get(1));
    }
}
