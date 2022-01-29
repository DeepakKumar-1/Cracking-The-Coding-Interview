package com.company.LinkedLists;

public class InsertNode {

    public static LinkedListNode createNode(int val) {
        return new LinkedListNode(val);
    }

    public static LinkedListNode insertAtFirst(LinkedListNode head, int val){
        // Create New Node
        LinkedListNode node = createNode(val);
        if(head == null){
            return node;
        } else {
            node.next = head;
            head = node;
        }
        return head;
    }

    public static LinkedListNode insertAtPosition(LinkedListNode head, int val, int pos){
        if(head == null){
            return insertAtFirst(head, val);
        }

        LinkedListNode nextNode = head.next;
        LinkedListNode prev = head;
        for(int i=0; i<pos - 2; i++){
            if(nextNode == null){
                System.out.println("Wrong Input");
                return head;
            }

            nextNode = nextNode.next;
            prev = prev.next;
        }

        LinkedListNode currentNode = createNode(val);
        prev.next = currentNode;
        currentNode.next = nextNode;
        return head;
    }

    public static LinkedListNode insertAtEnd(LinkedListNode head,int val){
        if(head == null){
            return insertAtFirst(head, val);
        }
        LinkedListNode node = head;
        while(node.next != null){
            node = node.next;
        }
        // Create a Node
        LinkedListNode newNode = createNode(val);
        node.next = newNode;
        newNode.next = null;
        return head;
    }

    public static void main(String []args){
        LinkedListNode head = null;
        head = insertAtFirst(head,20);
        head = insertAtFirst(head,40);

        head = insertAtEnd(head ,45);
        head = insertAtPosition(head, 56, 3);
        
        LinkedListNode obj = new LinkedListNode();
        obj.LinkedListTraversal(head);
        System.out.println();

    }

}
