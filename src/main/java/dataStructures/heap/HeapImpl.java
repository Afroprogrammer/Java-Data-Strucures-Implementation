package dataStructures.heap;

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

    }

    /**
     *  Builds heap in-place in linear time without using extra space
     */
    private void heapify(){

    }
/**
 * this method below makes sure that the heap is adjusted to the max heap after removal is done
 */
    private void adjust(int i, int n){
        int  j = 2 *1;  //this index signify the left child of the max heap
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
