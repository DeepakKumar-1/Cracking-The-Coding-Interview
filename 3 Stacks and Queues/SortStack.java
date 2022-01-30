package com.company.StackAndQueues;

import java.util.Stack;

public class SortStack {
    public static void insertAtProperPlace(int x, Stack<Integer> stack){
        if(stack.size() == 0|| x > stack.peek()){
            stack.push(x);
        } else{
            int a = stack.pop();
            insertAtProperPlace(x, stack);
            stack.push(a);
        }
    }

    public static void sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int x = stack.pop();
            sortStack(stack);
            insertAtProperPlace(x, stack);
        }
    }
    public static void displayStack(Stack<Integer> stack){
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String []args){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(6);
        stack.push(2);
        stack.push(10);
        sortStack(stack);
        displayStack(stack);
    }
}
