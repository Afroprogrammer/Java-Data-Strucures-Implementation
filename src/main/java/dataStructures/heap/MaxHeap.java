package dataStructures.heap;

/**
 * building a max heap
 * create a heapify function that takes an array, the length of the array and the node to heapify
 * variables needed
 * left node = 2 * i + 1;
 * right node = 2 * i + 2;
 * total number of nodes n = length of the array - 1;
 * last node which is a parent (n / 2) - 1
 * set the largest index to left or right child index if you check
 * <p>
 * basically heapify is a helper method to build a min or max heap from the last non-leaf node
 */
public class MaxHeap {

    public static void heapify(int[] arr, int i) {
        //creating the variables needed
        int largestIndex = i;
        int n = arr.length;
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;
        //check if the leftChild index is lesser than the heap length and if the child is greater than the largest
//        set the largestIndex to the leftChild
        if (leftChildIndex < n && arr[leftChildIndex] > arr[largestIndex]) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < n && arr[rightChildIndex] > arr[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        //if the largest value is not equal to root value swap and recursively do the heapify
        if (largestIndex != i) {
            int temp = arr[i];
            arr[i] = arr[largestIndex];
            arr[largestIndex] = temp;
            heapify(arr, largestIndex);
        }

    }

    static void buildHeap(int[] arr) {
        // Index of last non-leaf node
        int n = arr.length;
        int startIdx = (n / 2) - 1;
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, i);
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

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        int n = arr.length;
        buildHeap(arr);
        printHeap(arr);

    }
}
