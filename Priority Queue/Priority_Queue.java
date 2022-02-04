package com.company.PriorityQueue;

import java.util.ArrayList;

public class Priority_Queue {
    private ArrayList<Integer> heap;

    public Priority_Queue(){
        heap = new ArrayList<>();
    }

    boolean isEmpty(){
        return heap.size() == 0;
    }

    int size(){
        return heap.size();
    }

    int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            // Throw an Exception
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    public void insert(int element){
        heap.add(element);
        int childrenIndex = heap.size() - 1;
        int parentIndex = (childrenIndex - 1)/2;

        while(childrenIndex > 0){
            if(heap.get(childrenIndex) < heap.get(parentIndex)){
                int temp = heap.get(childrenIndex);
                heap.set(childrenIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childrenIndex = parentIndex;
                parentIndex = (childrenIndex - 1)/2;
            } else {
                return;
            }
        }
    }

    int removeMin() throws  PriorityQueueException {
        if (isEmpty())
            throw new PriorityQueueException();
        int temp = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int index = 0;
        int minIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while (leftChildIndex < heap.size()) {
            if (heap.get(leftChildIndex) < heap.get(minIndex))
                minIndex = leftChildIndex;
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex))
                minIndex = rightChildIndex;

            if(minIndex == index){
                break;
            }else {
                int temp1 = heap.get(index);
                heap.set(index, heap.get(minIndex));
                heap.set(minIndex, temp1);
                index = minIndex;
                leftChildIndex = (2 * index) + 1;
                rightChildIndex = (2 * index) + 2;
            }
        }
        return temp;
    }
}
