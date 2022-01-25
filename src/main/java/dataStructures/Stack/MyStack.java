package dataStructures.Stack;

public class MyStack {
    // creating the properties of the stack
    int numStack [] = null;
    int capacity = 5;
    // initiation a variable to represent the top value of an empty stack should be -1 denoting no data
    int top = -1;

 //creating a new constructor to create a new array
   public MyStack(){
        this.numStack = new int[capacity];
    }

    //creating a customized constructor to make a stack of specified size
    public  MyStack(int capacity){
       //store the incoming capacity to the existing one
        this.capacity = capacity;
        //create a new stack/array using the inputted capacity
       this.numStack = new int[capacity];
    }

    // Creating the push function of  a Stack

    public  void  push( int data )
    {
        //TODO  check if the is space in the stack
       if (isFull()){
           System.out.println("the stack is full cannot insert");
           return;
       }
        //inserting into the stack
        top = top + 1; //insert the top value to index position 1 to be able to insert
        numStack[top] = data;
        System.out.println( data + " inserted into stack");
    }

    public void pop (){
       if(isEmty ()){
           System.out.println("the stack is empty");
       }
       int data = numStack[top];
       top = top - 1;
        System.out.println(data + " has been removed");
    }

    public int peek() {
        if(isEmty()){
            System.out.println( "the stack is empty");
            return -1;
        }
        return numStack[top];
    }

    //checking if a stack is full
    public  boolean isFull (){
      return (top + 1) == capacity;
       }

    public  boolean isEmty (){
        return top == -1;
    }

    public static void main(String[] args) {
       MyStack stack = new MyStack();
        System.out.println("is the stack full? - " + stack.isFull());
        System.out.println("is the stack empty? - " + stack.isEmty());
       stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        System.out.println( stack.peek() + " this is the top element");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("is the stack full? - " + stack.isFull());
        System.out.println("is the stack empty? - " + stack.isEmty());
    }
}
