package dataStructures.HashMaps;

public class Hashmap {
    //creating the properties of the hashMap class
    //creating a class Hash node to which has key and values as members
    class HashNode {
        String key;
        String value;
        HashNode next; //reference that would help us chain same keys in one hashtable position.

        public HashNode(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    //creating hash table to maintain this the hashNode in the hash map

    private HashNode[] hashtable = null;
    private int bucketSize = 16;
    private int size = 0; //using it to track the size of the hashtable

    //creating a constructor of a Hashmap
    public Hashmap() {
        this.hashtable = new HashNode[bucketSize];
        ;
    }

    //creating a function to put and item into the hashtable
    public void put(String key, String value) {
        //find the index position you would like to store the key. do that by hashing it
        int position = hash(key);
        System.out.println("key - " + key);
        System.out.println("position - " + position);
        HashNode current = hashtable[position];
        //checking to see if there is no key in the current position on the hashtable
        if (current == null) {
            hashtable[position] = new HashNode(key, value);  //if its null put in the key value at the position
            size++;
        } else {
            while (current.next != null && current.key != key) {  //if the current is not null push it to the next
                current = current.next;
            }
            if (current.key == key) {
                current.value = value;
            } else {
                current.next = new HashNode(key, value);
                size++;
            }
            //after increase the size of the hashtable
        }
    }

    public boolean remove(String key) {
        int position = hash(key);   //finding the position index on a hashtable
        HashNode targetNode = hashtable[position]; //assigning the target hash-node to the node found at the table
        HashNode prev = null;
        HashNode curr = targetNode;
        while(curr != null && curr.key != key)  //traversing the list
        {
            prev = curr;
            curr = curr.next;
        }
        if(curr == null) return  false;
        if(prev == null) {
            hashtable[position] = curr.next;
        } else {
            prev.next = curr.next;
        }
        curr.next = null;
        size--;
        return true;
    }

    public String get(String key){
        HashNode targetNode = find(key); //using the findkey method to find the target node
        if (targetNode ==  null) return null;
        return targetNode.value;

    }

    public boolean contains(String key) {
        HashNode target = find(key);  //calling the find function here
        return target != null;
    }

    //A method to find a node when a key is passed takes a key as a parameter
    private HashNode find(String key) {
        int position = hash(key);    //finding the position index on a hashtable
        HashNode targetNode = hashtable[position]; //assigning the target hashnode to the one found at the table
        if (targetNode == null) return null;  //if there is no target node return null

        else {  //if we find a target node traverse the linkedlist
            while (targetNode != null && targetNode.key != key) {
                targetNode = targetNode.next;
            }
        }
        return targetNode;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode() % bucketSize);
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("{");
        for (int i = 0; i < bucketSize; i++) {
            HashNode node = hashtable[i];
            while (node != null) {
                buf.append(node.key).append("=").append(node.value);
                buf.append(",");
                node = node.next;
            }
        }
        if (buf.length() > 1) {
            buf.deleteCharAt(buf.length() - 1);
        }
        buf.append("}");
        return buf.toString();
    }

    public static void main(String[] args) {
        Hashmap map = new Hashmap();
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        System.out.println("----------BEFORE REMOVING----------------");
        System.out.println( map);
        map.remove("one");
        System.out.println("----------AFTER REMOVING----------------");
        System.out.println(map);


    }
}
