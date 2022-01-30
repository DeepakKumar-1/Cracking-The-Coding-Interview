package com.company.StackAndQueues;
import java.util.Stack;

class MyQueue<T>{
    Stack<T> stackNewest, stackOldest;
    public MyQueue(){
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public int size(){
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value){
        stackNewest.push(value);
    }

    public void shiftStacks(){
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek(){
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove(){
        shiftStacks();
        return stackOldest.pop();
    }
}
public class QueuesViaStack {
    public static void main(String []args) {
        MyQueue<Character> obj = new MyQueue<>();
        obj.add('d');
        obj.add('e');
        obj.add('e');
        obj.add('p');
        obj.add('a');
        obj.add('k');
        System.out.println(obj.remove());
        System.out.println(obj.remove());
        System.out.println(obj.remove());
        obj.add('P');
        System.out.println(obj.remove());
        System.out.println(obj.peek());
    }
}
