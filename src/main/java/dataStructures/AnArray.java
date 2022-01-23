package dataStructures;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AnArray {
    public static void main(String[] args){
        // creating and array for five elements
        String[] name = new String[5];

        // adding elements
        name[0] = "joe";
        name[1] = "ama";
        name[2] = "adwoa";
        name[3] = "akosua";
        name[4] = "yaa";
        //printing all the list with Arrays.toString method
        System.out.println("=========================================");
        System.out.println("printing all the list with Arrays.toString method");
        System.out.println("=========================================");
        System.out.println(Arrays.toString(name));

        // accessing the element at a particular index
        System.out.println("=========================================");
        System.out.println("printing the element at a particular index");
        System.out.println("=========================================");
        System.out.println(name[1]);

        //looping through your array
        System.out.println("=========================================");
        System.out.println("looping through your array");
        System.out.println("=========================================");
        for (int i = 0 ; i < name.length -1; i++)
        {
            System.out.println(name[i]);
        }
        //using the enhanced for loop
        System.out.println("=========================================");
        System.out.println("using the enhanced for loop ");
        System.out.println("=========================================");
        for (String names: name)
        {
            System.out.println(names);
        }

        //deleting and element from an array
        System.out.println("=========================================");
        System.out.println("deleting and element from an array ");
        System.out.println("=========================================");

        int[] arr = { 1, 2, 3, 4, 5 };

        // Print the resultant array
        System.out.println("Printing the Original Array: " + Arrays.toString(arr));

        // Get the specific index
        int index = 2;

        // Print the index
        System.out.println("Index to be removed: " + index);

        // Remove the element
        arr = removeInt(arr, index);

        // Print the resultant array
        System.out.println("Resultant Array: "
                + Arrays.toString(arr));

        System.out.println("=========================================");
        System.out.println("adding an element into an array");
        System.out.println("=========================================");

        int n = 10;
        int i;

        // initial array of size 10
        int numarray[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // print the original array
        System.out.println("Initial Array:\n"
                + Arrays.toString(numarray));

        // element to be added
        int x = 50;

        // call the method to add x in arr
        numarray = addX(n, numarray, x);

        // print the updated array
        System.out.println("\nArray with " + x
                + " added:\n"
                + Arrays.toString(numarray));

    }

    //method to delete and element from an array
    public static int[] removeInt (int[] arr, int index)
    {
        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        // return the resultant array
        return IntStream.range(0, arr.length)
                .filter(i -> i != index)
                .map(i -> arr[i])
                .toArray();
    }
    public static int[] addX(int n, int numarray[], int x) {
        int i;

        // create a new array of size n+1
        int newarray[] = new int[n + 1];

        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarray[i] = numarray[i];

        newarray[n] = x;

        return newarray;
    }
}
