package com.company.Trees;

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

public class MirrorBinaryTree {
    public static <T>BinaryTreeNode<T> createNode(T val){
        return new BinaryTreeNode<>(val);
    }

    public static void preOrder(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void mirror(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        mirror(root.left);
        mirror(root.right);
        BinaryTreeNode<Integer> Temp = root.left;
        root.left = root.right;
        root.right = Temp;
    }

    public static void main(String []args){
        BinaryTreeNode<Integer> root, n1, n2, n3, n4, n5, n6, n7, n8;
        root = createNode(8);
        n1 = createNode(3);
        n2 = createNode(10);
        n3 = createNode(1);
        n4 = createNode(6);
        n5 = createNode(14);
        n6 = createNode(4);
        n7 = createNode(7);
        n8 = createNode(13);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        n4.left = n6;
        n4.right = n7;
        n5.left = n8;
        
        preOrder(root);
        mirror(root);
        preOrder(root);
    }
}
