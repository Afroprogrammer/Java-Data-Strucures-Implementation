package dataStructures.HashMaps;

import dataStructures.DoublyLinkedList.DoublyLinkedList;

public class LinkedHashMap  extends Hashmap {

    class LinkedHashNode extends Hashmap.HashNode {
        LinkedHashNode after;   //micking the doubly linked properties here.. before and after nodes
        LinkedHashNode before;

        public LinkedHashNode(String key, String value) {
            super(key, value);
        }
    }
        LinkedHashNode head;  //node pointers to track things in our linkedHashmap
        LinkedHashNode tail;

        @Override
        public HashNode createHashNode(String key, String value ) {
            LinkedHashNode newNode = new LinkedHashNode(key, value);
            nodeLinking(newNode);
            return newNode;
        }
        private void nodeLinking(LinkedHashNode current){
            if (head == null) {
                head = tail = current;
            } else {
                tail.after = current;
                current.before = tail;
                tail = current;
            }
        }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        LinkedHashNode currentPointerNode = head;
        buf.append("{");
            while (currentPointerNode != null) {
                buf.append(currentPointerNode.key).append("=").append(currentPointerNode.value);
                buf.append(",");
                currentPointerNode = currentPointerNode.after;
            }
        if (buf.length() > 1) {
            buf.deleteCharAt(buf.length() - 1);
        }
        buf.append("}");
        return buf.toString();
    }


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