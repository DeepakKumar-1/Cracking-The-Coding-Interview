package com.company.StackAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class StackMin {
    private static Stack<Integer> stack = new Stack<>();
    private static int min = Integer.MAX_VALUE;
    public static void push(int value){
        if(value < min){
            min = value;
            stack.push(value);
        }
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Elements to Create the Stack: ");
        while(true){
            int value = sc.nextInt();
            if(value == -1){
                break;
            }else {
                push(value);
            }
        }
        System.out.println("Minimum Element of the Stack is: " + min);
    }
}
