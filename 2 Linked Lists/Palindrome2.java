package com.company.LinkedLists;

import java.util.Stack;

public class Palindrome2 {

    public static LinkedListNode createNode(int val) {
        return new LinkedListNode(val);
    }

    public static boolean isPalindrome(LinkedListNode head){
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        Stack<Integer> stack = new Stack<>();

        while(fast != null && fast.next != null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // If Linked List contain odd Number of Elements then Skip the Middle
        if(fast != null){
            slow = slow.next;
        }

        while(slow != null){
            int top = stack.pop();
            if(top != slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String []args){
        // Create  a Linked List
        LinkedListNode head, n1, n2, n3;
        head = createNode(2);
        n1 = createNode(3);
        n2 = createNode(2);
        n3 = createNode(2);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;

        LinkedListNode obj = new LinkedListNode();
        obj.LinkedListTraversal(head);
        System.out.println();
        System.out.println("Is Palindromic Linked List: " + isPalindrome(head));
    }
}
