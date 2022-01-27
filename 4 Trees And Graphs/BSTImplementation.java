package com.company.Trees;

import java.util.LinkedList;
import java.util.Queue;

 class BinaryTreeNode<T>{
    T val;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    BinaryTreeNode(T val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BST{
    private  BinaryTreeNode<Integer> root;
    public BST(){
        root = null;
    }

    private  boolean searchHelper(BinaryTreeNode<Integer> root, int data){
        if(root == null){
            return false;
        }
        if(root.val == data){
            return true;
        }
        if(root.val > data){
            // Search in left SubTree
            return searchHelper(root.left, data);
        } else{
            return searchHelper(root.right, data);
        }
    }
    public  boolean search(int data){
        return searchHelper(root, data);
    }

    private  BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int data){
        if(root == null){
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);
            return newNode;
        }
        if(root.val > data){
            root.left = insertHelper(root.left, data);
        } else{
            root.right = insertHelper(root.right, data);
        }
        return root;
    }

    public  void insert(int data){
        root = insertHelper(root, data);
    }

    private  BinaryTreeNode<Integer> deleteHelper(BinaryTreeNode<Integer>root, int data){
        // Base Case
        if(root == null){
            return null;
        }

        if(data < root.val){
            root.left = deleteHelper(root.left, data);
            return root;
        } else if(data > root.val){
            root.right = deleteHelper(root.right, data);
            return root;
        } else{
            //  To Remove Root Itself
            if(root.left == null && root.right == null){
                return null;
            } else if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            } else {
                BinaryTreeNode<Integer> minNode = root.right;
                while(minNode.left != null){
                    minNode = minNode.left;
                }
                root.val = minNode.val;
                root.right = deleteHelper(root.right, minNode.val);
                return root;
            }
        }
    }

    public  void delete(int data){
        root = deleteHelper(root, data);
    }

    public void levelOrderTraversal(BinaryTreeNode<Integer> root){
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> currentRoot = queue.poll();
            System.out.print(currentRoot.val + " ");
            if(currentRoot.left != null){
                queue.add(currentRoot.left);
            }
            if(currentRoot.right != null){
                queue.add(currentRoot.right);
            }
        }
    }

    public void levelOrderTraversal(){
        levelOrderTraversal(root);
    }
}

public class BSTImplementation {
    public static void main(String [] args){
        BST obj = new BST();
        obj.insert(10);
        obj.insert(5);
        obj.insert(20);
        obj.insert(3);
        obj.insert(7);
        obj.insert(15);

        obj.levelOrderTraversal();
        obj.delete(10);
        System.out.println();
        obj.levelOrderTraversal();
    }
}
