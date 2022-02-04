package com.company.PriorityQueue;

public class Main {
    public static void main(String [] args) throws PriorityQueueException{
        Priority_Queue pq = new Priority_Queue();
        int []arr = {5,1,9,2,0};
        for (int element : arr){
            pq.insert(element);
        }
        while(!pq.isEmpty()){
            System.out.print(pq.removeMin() + " ");
        }
        System.out.println();
    }
}
