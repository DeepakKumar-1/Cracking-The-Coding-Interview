package com.company.LinkedLists;

public class Palindrome {

    public static LinkedListNode createNode(int val) {
        return new LinkedListNode(val);
    }

    public static boolean isPalindrome(LinkedListNode head){
        LinkedListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    public static boolean isEqual(LinkedListNode h1, LinkedListNode h2){
        while(h1 != null && h2 != null){
            if(h1.val != h2.val){
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1 == null && h2 == null;
    }

    public static LinkedListNode reverseAndClone(LinkedListNode node){
        LinkedListNode head = null;
        while(node != null){
            LinkedListNode n = new LinkedListNode(node.val);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
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
