package com.company;

class FullStackException extends Throwable {
}
class EmptyStackException extends Throwable{
}
public class StacksAndQueues {
    private int noOfStacks = 3;
    private int stackCapacity ;
    private int[]values;
    private int[]sizes;
    
    public void FixedMultiStack(int stackSize){
        stackCapacity = stackSize;
        values = new int[stackSize * noOfStacks];
        sizes = new int[noOfStacks];
    }
    
    // Push the Value in the Stack
    public void push(int stackNum, int value) throws FullStackException{
        if(isFull(stackNum)){
            System.out.println("Stack is Full");
            throw new FullStackException();
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }
    
    // Pop the Element
    public int pop(int stackNum) throws EmptyStackException{
        if(isEmpty(stackNum)){
            System.out.println("Stack is Empty");
            throw new EmptyStackException();
        } 
        
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex]--;
        return value;
    }
    
    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }
    
    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }
    
    public int indexOfTop(int stackNum){
        int offset = stackNum*stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
