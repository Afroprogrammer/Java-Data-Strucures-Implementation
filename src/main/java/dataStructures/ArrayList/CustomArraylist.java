package dataStructures.ArrayList;
import java.util.Arrays;

public class CustomArraylist {
// implementing adding a value into the array
    //creating a null int array
    int arr [] = null;
    int capacity = 5; //creating an initial size for the array
    int size = 0; //this variable would use to track the initial size of the array

    //creating the constructor for the array
    public CustomArraylist()
    {
        this.arr = new int[capacity];
    }

    //creating another custom constructor for the arraylist to increase the capacity
    public CustomArraylist(int capacity)
    {
        this.capacity = capacity;
        this.arr = new int[capacity]; //creating a new arraylist from the capacity
    }

//inserting the new data into the arraylist
    public void add(int data ){
        //checking if the capacity overflow and create a new dynamic bigger list
        capacityCheck();
        //assigning the data into the arraylist using the data the arraylist
        arr[size] = data;
        //increase the size value
        size++;
        System.out.println( data + " the data was inserted into the list");
    }

    //inserting into a specific location
    public void add( int data , int index){
        //validate the index position
          if(index > size - 1 || index < 0)
          {
              System.err.println("index is out of range");
             return;
          }
        capacityCheck();
        for (int i = size; i > index; i--){
            arr[i] = arr[i - 1];    //getting the current element at the index and saving it to the next free space;
        }
        arr[index] = data;
        size++;
        System.out.println( data + " was inserted into the list");
    }
     private void capacityCheck(){
         if(size == capacity){
             System.out.println("Array overflow creating new array");
             capacity = capacity + (capacity >> 1); //setting a bigger capacity
             System.out.println( " the new capacity is " + capacity);
             //creating a new array
             int newArr[] = new int[capacity];

             //copy things from the old array to the new array
             for (int i = 0; i < size; i++)
             {
                 newArr[i] = arr[i];
             }
             //assign the old array to the new array
             this.arr = newArr;
         }
     }

     public void remove (int index){
        //check if index is valid
        if( index > size - 1  || index < 0){
            System.err.println("invalid index");
            return;
        }
        //check the data in that position
         int data = arr[index];
        //swap the data to that index position
       for (int i  = index; i < size - 1; i++)
       {
           arr[i] = arr[i + 1];
       }
         size --;
         System.out.println(data + "was removed");
     }




//overriding the to string method not to print the object reference
@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < size; i++) {
        sb.append(arr[i]).append(",");
    }
    if(sb.length()>1) {
        sb.deleteCharAt(sb.length()-1);
    }
    sb.append("]");
    return sb.toString();
}


    public static void main(String[] args) {
       //Implementing adding into an arraylist
        CustomArraylist arraylist = new CustomArraylist();
        arraylist.add(10);
        arraylist.add(20);
        arraylist.add(30);
        System.out.println(arraylist);
        arraylist.add(70);
        System.out.println(arraylist);
        //inserting to an index of my choice
        arraylist.add(80,2);
        System.out.println(arraylist + "after inserting");
        arraylist.add(79);
        System.out.println(arraylist);
        arraylist.remove(0);
        System.out.println(arraylist);
    }
}
