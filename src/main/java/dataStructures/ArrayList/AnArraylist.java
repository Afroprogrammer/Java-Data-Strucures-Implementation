package dataStructures.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class AnArraylist {
    public static void main(String[] args) {
        //creating and arraylist
        List<String> colors = new ArrayList<>();
        //In java, you can specify datatype your list can take eg. List<String> it can take only string objects
        //adding to an arraylist

        colors.add("blue");
        colors.add("red");
        colors.add("yellow");

        //printing out from a list
        System.out.println("+++++++++printing out from a list +++++++++++");
        System.out.println(colors);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        //other methods you can call  on an arraylist

        System.out.println("+++++++++checking the size of the list ++++++");
        System.out.println(colors.size());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("++++++checking if it contains an element+++++");
//        returns a boolean if it contains
        System.out.println(colors.contains("blue"));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
//looping through the arraylist 
        System.out.println("+++++++looping through and arraylist ++++++++");

        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

        //another way to loop through the arraylist
        System.out.println("+++++looping through and arraylist another way ++++");
        for (String coloring : colors) {
            System.out.println(coloring);
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

       //Manually extending the list
        System.out.println("+++++++++++++++++++++Manually extending the list++++++++++++++++++++++++");
        List <Integer> numberArray = new ArrayList<>();
        numberArray.add(1);
        numberArray.add(2);
        numberArray.add(3);
        numberArray.add(4);
        numberArray.add(5);

        List<Integer> newNumberarray = new ArrayList<>(numberArray);
        newNumberarray.add(500);
        newNumberarray.add(1000);

        System.out.println("this is the old list " + numberArray);

        System.out.println("this is the new list " + newNumberarray);

    }
}

