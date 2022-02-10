package SearchingAlgorithm.QuickSort;

public class QuickSort {

    //quick sort method that would take in a lower and upper index with the array to sort
    private static void quicksort(int [] array, int lowIndex, int highIndex){
        //base case for the recursion
        if (lowIndex >= highIndex){
            return;
        }

        //choosing a pivot
        int pivot = array[highIndex];  //choosing the last index of the array as the pivot
        //partitioning the array
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer){  //whiles the left pointer is lesser than the right pointer
                while(array[leftPointer] <= pivot && leftPointer < rightPointer){   //check if value of the left is equal to or lesser than the pivot to break out the while loop
                    leftPointer++;

                }

            while(array[rightPointer] >= pivot && leftPointer < rightPointer){   //check if value of the left is equal to or lesser than the pivot to break out the while loop
                leftPointer--;

            }

            swap(array , leftPointer, rightPointer); //if the conditions in the inner while loop breaks the elements swap
        }
            //if not swap the pivot with the low index value
        swap(array, leftPointer, highIndex);
        //recursively quick sort the left side and right side of the array
        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);
    }

    private static void swap(int [] array , int lowPointer, int highPointer ){
        int temp = array[lowPointer];
        array[lowPointer] = array[highPointer];
        array[highPointer] = temp;
    }
}
