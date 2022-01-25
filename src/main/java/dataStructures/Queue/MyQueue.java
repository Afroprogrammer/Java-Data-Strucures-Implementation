package dataStructures.Queue;

import java.util.Queue;

public class MyQueue {
    //setting private properties of an array and an initial capacity
    int capacity = 5;
    int arr [] = null;

    //first element of the queue
    int front = 0;

    //denotes the last spot of the queue its empty its set to negative one
     int rear = -1;

    //default constructor
    public MyQueue(){
        this.arr = new int [capacity];
    }

    //creating a queue with your own capacity
    public MyQueue( int capacity){
        this.capacity = capacity;
        this.arr = new int [capacity];
    }

    public void enqueue(int data)
    {
        if(rear+1 == capacity){
            System.out.println(" the queue if full");
            return;
        }
        //increase the rear to one
        rear = rear + 1;
        //THEN store the data in the rear area
        arr[rear] = data;
        System.out.println(data + " enqueued into the Queue");

    }

    public void dequeue(){
        if(front == rear+1){
            System.err.println("the queue is empty");
            return;
        }
        //get the front element from array arr[front]
        //shift down
        int data = arr[front]; //getting the front value
        for(int i = front; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear --;
        System.out.println(data + " deqeued from Queue" );
    }
  public int rear (){
        if(front  == rear+1){
            System.out.println("The queue is empty");
            return  Integer.MIN_VALUE;
        }
        return arr[rear];
  }

    public int front (){
        if( front  == rear+1){
            System.out.println("the queue is full");
            return  Integer.MIN_VALUE;
        }
        return arr[front];
    }
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        System.out.println( " After inserting the data");
        System.out.println("Rear item is: " + queue.rear());
        System.out.println("Front item is: " + queue.front());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();



    }
}
