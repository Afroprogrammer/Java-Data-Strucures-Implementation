package dataStructures.Trie;

import org.w3c.dom.Node;

import java.util.Locale;

public class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode(); // root is empty
    }
    private class TrieNode{
        TrieNode [] children;
        boolean isWord;
        int capacity = 26;

        public TrieNode(){
            this.children = new TrieNode[capacity];  //capacity for storing english words
            this.isWord = false;
        }
    }

    public void insert (String word){
        if(word == null || word.isBlank()|| word.isEmpty()){
            throw  new IllegalArgumentException("invalid input ");
        }
        word = word.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c -'a';   //finding the index of the trie node
            if (current.children[index] == null){
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            }else
            {
                current = current.children[index];
            }
            current.isWord = true;
        }

    }

    public boolean startsWith(String prefix){
        TrieNode node = getNode(prefix);
        return node != null;
    }


    private TrieNode getNode(String word){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(current.children[index] == null){
                return null;
            }else{
                current = current.children[index];
            }
        }
        return current;
    }
    public boolean search(String word){
        TrieNode node = getNode(word);
        return node != null && node.isWord;
    };

    public static void main(String[] args) {
        Trie newTrie = new Trie();
        newTrie.insert("cat");
        newTrie.insert("cab");
        newTrie.insert("cake");
        newTrie.insert("son");
        newTrie.insert("son");
        System.out.println("words added successfully");

    }
}
