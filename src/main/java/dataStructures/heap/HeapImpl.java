package dataStructures.heap;

import java.util.Random;

public class HeapImpl {
    int size;  //to check the size of the array of the heap created
    private int [] arr;

    public HeapImpl( int size){

        //allocating is more than actual size
        //so that we can use from index 1 to size
        arr = new int[size + 1];
    }

    /**
     *  Sorts the array using heapsort logic after building heap in place using heapify
     */
    public void heapSort(){
        heapify();    //do this by converting an array to a heap
        int n = arr.length - 1;
        for (int i = n; i >= 2; --i){
            int temp = arr[1];    //getting the content of the root and storing it to temp
            arr[1] =  arr[i];    // copying the last element to the root
            adjust(1, i-1);  //calling the adjust method because the heap is not a heap anymore
            arr[i] = temp; //taking the popped of element and storing it in the sorted array
        }


    }

    /**
     *  Builds heap in-place in linear time without using extra space
     */
    private void heapify(){
        int i;
        int n = arr.length - 1;
        for(i = n/2; i >=1; --i){
            adjust(i, n);
        }
    }
/**
 * this method below makes sure that the heap is adjusted to the max heap after removal is done
 */
    private void adjust(int i, int n){
        int  j = 2 * i;  //this index signifies the left child of the max heap
        int item = arr[i];   //the item at the first index
        while (j <= n ) {  //when j is less that means there are children in the tree
            if (j < n && arr[j] < arr[j + 1]) {
                j = j + 1;           //here we are comparing the two children if the right is bigger than the left we swap
            }
            if (item >= arr[j])
                break;
            arr[j/2] = arr[j];
            j = 2 * j;
        }
         arr[j/2] = item;
    }
   public void fillRandomData(){   //creating a helper function that generates random numbers
       Random random = new Random();
       for(int i = 1; i <  arr.length; i++){
           arr[i] = random.nextInt(10);
       }
   }

   public void printArray(){
        for (int nums : arr)
        {
            System.out.print(nums + " ");
        }

       System.out.println(" ");
   }

    public boolean isSorted(boolean ascendingOrder){
        boolean sorted = true;

        for(int i = 1; i < arr.length - 1 && sorted; ++i ){
            if(ascendingOrder && arr[i] > arr[i + 1]){
                sorted = false;
            }
        }
        return  sorted;

    }


    public static void main(String[] args) {

    }

}
