package SearchingAlgorithm.MergeSort;

public class MergeSort {

    private static void mergeSort(int [] inputArray){
        int inputLength = inputArray.length;

        if (inputLength < 2){   //the base case of the recursion when the array length is less than one return
            return;
        }

        int midIndex = inputLength/2;  //finding the middle index
        int [] leftHalf = new int [midIndex];   //getting the left half of the array
        int [] rightHalf = new int [inputLength - midIndex]; //getting the right half of the array;

        //splitting the array from left half to right half using a for loop
        for(int i = 0; i < midIndex; i++){       //ith index starting from zero
            leftHalf[i] = inputArray[i];
        }
        for(int i = midIndex; i < inputLength - midIndex; i++){     //index starting from middle index
            rightHalf[i - midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
    }


    private static void merge ( int [] inputArray, int [] left, int [] right){
        int i = 0;
        int  j = 0;
        int k = 0;      //variables set to zero to track the iteration
        while( i < left.length && j < right.length){    //while the count is less
            if (left[i] <= right[i]) {
                inputArray[k] = left[i];
                i++;
            } else
            {
                inputArray[k] = right[j];
                j++;
            }
            k++;
        }
         while( i < left.length){
             inputArray[k] = left[i];
             k++;
             i++;
         }
        while( j < right.length){
            inputArray[k] = right[j];
            k++;
            j++;
        }

    }

    public static void main(String[] args) {

    }
}
