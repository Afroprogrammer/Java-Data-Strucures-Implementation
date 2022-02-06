package SearchingAlgorithm;

public class SelectionSort {

    //helper function to print out an array

    private  static void printArray(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }

        System.out.println();
    }

    private static  void swap( int array[], int left , int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
