package SearchingAlgorithm.MergeSort;

public class MergeSort {

    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {   //the base case of the recursion when the array length is less than one return
            return;
        }

        int midIndex = inputLength / 2;  //finding the middle index
        int[] leftHalf = new int[midIndex];   //getting the left half of the array
        int[] rightHalf = new int[inputLength - midIndex]; //getting the right half of the array;

        //splitting the array from left half to right half using a for loop
        for (int i = 0; i < midIndex; i++) {       //ith index starting from zero
            leftHalf[i] = inputArray[i];
        }
        for (int i = midIndex; i < inputLength; i++) {     //index starting from middle index
            rightHalf[i - midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(inputArray, leftHalf, rightHalf);
    }


    private static void merge(int[] inputArray, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;      //variables set to zero to track the iteration
        while (i < left.length && j < right.length) {    //while the count is less
            if (left[i] <= right[i]) {
                inputArray[k] = left[i];
                i++;
            } else {
                inputArray[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            inputArray[k] = left[i];
            i++;
            k++;

        }
        while (j < right.length) {
            inputArray[k] = right[j];
            j++;
            k++;

        }

    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arrayss = {12, 13, 15, 63, 2, 7, 6, 5, 48, 9, 0, 1, 45, 68, 23, 4, 5};
        System.out.println("Before ....");
        printArray(arrayss);

        mergeSort(arrayss);
        System.out.println("After  ....");
        printArray(arrayss);


    }
}
