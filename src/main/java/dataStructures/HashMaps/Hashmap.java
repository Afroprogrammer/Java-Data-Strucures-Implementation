package dataStructures.HashMaps;

public class Hashmap {
    //creating the properties of the hashMap class
    //creating a class Hash node to which has key and values as members
    class HashNode{
        String key;
        String value;

        public HashNode(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    //creating hash table to maintain this the hashNode in the hash map

    private HashNode hastable []  = null;
    private int bucketSize = 16;
    private int size = 0; //using it to track the size of the hashtable

    //creating a constructor of a Hashmap
    public Hashmap(){
        this.hastable = new HashNode[bucketSize];;
    }
    //creating a function to put and item into the hashtable
    public void put(String key, String value){
        //find the index position you would like to store the key. do that by hashing it
        int position = hash(key);
        System.out.println("key - " + key);
        System.out.println("position - " + position);
        hastable[position] = new HashNode(key, value);  //storing a hashNode in our hashtable
        size++;

    }

    //creating the hash method
    private int hash( String key ){
        return Math.abs(key.hashCode() % bucketSize);
    }
    public static void main(String[] args) {
        Hashmap map  = new Hashmap();
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
    }
}
