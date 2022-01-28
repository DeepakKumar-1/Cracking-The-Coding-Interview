package com.company.ArraysAndStrings;
import java.util.ArrayList;

class MapNode<K, V>{
    K key;
    V value;
    MapNode<K, V> next;
    public MapNode(K key, V value){
        this.key = key;
        this.value = value;
    }
}

class Hash_Map<K, V>{
    ArrayList<MapNode<K, V>> buckets;
    int size;
    int noOfBuckets;
    public Hash_Map(){
        this.size = 0;
        this.noOfBuckets = 20;
        buckets = new ArrayList<>();
        for(int i=0; i<20; i++){
            buckets.add(null);
        }
    }

    private int getBucketIndex(K key){
        int hasCode = key.hashCode();
        return hasCode % noOfBuckets;
    }

    public int size(){
        return size;
    }

    public V removeKey(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev = null;
        while(head != null){
            if(head.key.equals(key)){
                size--;
                if(prev == null){
                    buckets.set(bucketIndex, head.next);
                }else{
                    prev.next = head.next;
                }
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public V getValue(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void put(K key, V value){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = buckets.get(bucketIndex);
        MapNode<K, V> newElementNode = new MapNode<>(key, value);
        size++;
        newElementNode.next = head;
        buckets.set(bucketIndex, newElementNode);
        double loadFactor = (1.0 * size)/ noOfBuckets;
        if(loadFactor > 0.7){
            rehash();
        }

    }

    public double loadFactor(){
        return (1.0 * size)/noOfBuckets;
    }

    private void rehash(){
        ArrayList<MapNode<K, V>>temp =  buckets;
        buckets = new ArrayList<>();
        for(int i=0; i<2*noOfBuckets; i++){
            buckets.add(null);
        }
        size = 0;
        noOfBuckets = 2 * noOfBuckets;
        for(int i=0; i<temp.size(); i++){
            MapNode<K, V> head = temp.get(i);
            while(head != null){
                K key = head.key;
                V value = head.value;
                put(key, value);
                head = head.next;
            }
        }
    }
}
public class HashMapImplementation {
    public static void main(String []args){
        Hash_Map<Integer, Boolean> map = new Hash_Map<>();
        map.put(1, true);
        System.out.println(map.getValue(1));
        Boolean k = map.removeKey(1);
        System.out.println(map.getValue(1));
    }
}
