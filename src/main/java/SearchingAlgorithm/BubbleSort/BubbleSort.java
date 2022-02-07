package SearchingAlgorithm.BubbleSort;

public class BubbleSort {

    public static int[] sort(int[] array) {
          int i , j , temp = 0;
        for ( i = 0; i < array.length - 1; i++) {
            for ( j =  1; j < array.length - i ; j++) {
                if (array[j-1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
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