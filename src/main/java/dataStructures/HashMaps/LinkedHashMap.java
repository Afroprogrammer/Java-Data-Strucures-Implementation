package dataStructures.HashMaps;

import dataStructures.DoublyLinkedList.DoublyLinkedList;

public class LinkedHashMap  extends Hashmap {

    class LinkedHashNode extends Hashmap.HashNode{
        LinkedHashNode after;   //micking the doubly linked properties here.. before and after nodes
        LinkedHashNode before;

        public LinkedHashNode(String key, String value){
            super(key, value);
        }

        LinkedHashNode head;  //node pointers to track things in our linkedHashmap
        LinkedHashNode tail;

    }

    public HashNode createHashNode(String key, String value ) {
       LinkedHashNode newNode = new LinkedHashNode(key, value);
       return newNode;
    }

    //creating a method to maintain order after node insertion


    public static void main(String[] args) {
        Hashmap map = new LinkedHashMap();
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
//        System.out.println("----------BEFORE REMOVING----------------");
//        System.out.println(map);
//        map.remove("one");
//        System.out.println("----------AFTER REMOVING----------------");
        System.out.println(map);


    }
}