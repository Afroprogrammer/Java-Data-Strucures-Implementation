package SearchingAlgorithm.BubbleSort;

public class BubbleSort {

    public static int[] sort(int[] array) {
          int i , j , temp = 0;
        for ( i = 0; i < array.length - 1; i++) {   //O(n) code is O(n) here
            for ( j =  1; j < array.length - i ; j++) { //O(n - j + i)
                if (array[j-1] > array[j]) {  //O(1)
                    temp = array[j - 1];  //O(1)
                    array[j - 1] = array[j];   //O(1)
                    array[j] = temp;    //O(1)
                }
            }
        }
        return array;    //O(1)
    }

    public static void printArray(int [] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
        int [] nums = {6,5,4,7,8,9,10,2,1,3};
        printArray(nums);
        sort(nums);
        printArray(nums);
    }
}