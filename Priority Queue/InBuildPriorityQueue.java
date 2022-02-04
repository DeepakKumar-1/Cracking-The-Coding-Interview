package com.company.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class InBuildPriorityQueue {
    public static void main(String [] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int [] arr = {9, 1, 4, 7, 3};
        for(int element : arr){
            pq.add(element);
        }
       while(!pq.isEmpty())
           System.out.print(pq.remove() + " ");
    }
}
