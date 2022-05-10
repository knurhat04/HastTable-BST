package com.company;

public class MyHashTable <K,V>{
    private class HashNode<K,V>{
        private K key;
        private V value;
        private HashNode<K,V> next;
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + '}';
        }
    }
    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(){
        this(11);
    }
    public MyHashTable(int M){
        this.M = size;
        chainArray = new HashNode[M];
        this.size = 0;
    }
    private int hash(K key){
        return key.toString().length() % chainArray.length;
    }

    public void put(K key, V value){
        int hashedKey = hash(key);
        HashNode head = chainArray[hashedKey];
        HashNode newItem = new HashNode(key,value);
        newItem.next = head.next;
        head.next = newItem;
    }

    public V get(K key){
        int hashedKey = hash(key);
        HashNode head = chainArray[hashedKey];
        while(head != null) {
            if(head.key == key) {
                System.out.println(head.value);
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int hashedKey = hash(key);
        HashNode head = chainArray[hashedKey];
        HashNode previous = null;
        while(head!= null){
            if(head.key == key){
                break;
            }
            previous = head;
            head = head.next;
        }
        if(head == null){
            return null;
        }
        size--;
        if(previous != null){
            previous.next = head.next;
        }
        else{
            chainArray[hashedKey] = head.next;
        }
        return (V) head.value;
    }

    public boolean contains(V value){
        return contains(value);
    }

    public void getKey(V value){
        int hashedValue = hash((K) value);
        HashNode head = chainArray[hashedValue];
        while(head != null){
            if(head.value == value){
                System.out.println(head.key);
            }
            head = head.next;
        }
    }
}


