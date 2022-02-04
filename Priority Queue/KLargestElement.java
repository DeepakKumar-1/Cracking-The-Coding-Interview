package com.company.PriorityQueue;
import java.util.PriorityQueue;

public class KLargestElement {
    public static void main(String [] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int [] arr = {1,4,5,2,0};
        int  k = 3;
        for(int element : arr){
            pq.add(element);
        }
        int largest = 0;
        for(int i=0; i<k; i++){
            largest = pq.remove();
        }
        System.out.print(largest);

    }
}
