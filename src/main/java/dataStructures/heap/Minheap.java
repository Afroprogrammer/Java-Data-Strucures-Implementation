package dataStructures.heap;

/**
 * Building a min heaap the parent should be lesser than the children.
 * in the build heap function finding the last non leaf parent is used as the
 * length of the mini array. when heapify is called the inde
 */
public class Minheap {
    //would need a helper heapify function.
    public static void heapify(int [] arr, int i){
        int lenOfArray = arr.length;
        int rightChildIndex = 2 * i + 2;
        int leftChildIndex = 2 * i + 1;
        int largestIndex = i;


        if (leftChildIndex < lenOfArray && arr[leftChildIndex] < arr[largestIndex]) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < lenOfArray && arr[rightChildIndex] < arr[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        if(largestIndex != i){
            int temp = arr[i];
            arr[i] = arr[largestIndex];
            arr[largestIndex] = temp;
            heapify(arr, largestIndex);
        }

    }

    // A utility function to print the array
    // representation of Heap
    static void printHeap(int arr[]) {
        System.out.println(
                "Array representation of Heap is:");
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
   public static void buildHeap(int arr[]){
        int arrayLen = arr.length;
        int index = (arrayLen/2) - 1;
       for (int i = index; i >= 0; i--) {
           heapify(arr, i);
       }
   }

    public static void main(String[] args) {
        int arr[] = {4, 6, 13, 8, 15, 1, 3, 5, 10, 9, 17};
        int n = arr.length;
        buildHeap(arr);
        printHeap(arr);
    }
}
