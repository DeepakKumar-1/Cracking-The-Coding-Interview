package com.company.Trees;

class Pair{
    int height;
    int diameter;

    Pair(int height, int diameter){
        this.height = height;
        this.diameter = diameter;
    }
}

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


public class DiameterOfTree {
    public static <T>BinaryTreeNode<T> createNode(T val){
        return new BinaryTreeNode<>(val);
    }


    public static Pair diameterHelper(BinaryTreeNode<Integer> root){
        if(root == null){
            return new Pair(0, 0);
        }

        Pair leftPair =  diameterHelper(root.left);
        Pair rightPair = diameterHelper(root.right);
        int leftDiameter = leftPair.diameter;
        int rightDiameter = rightPair.diameter;

        int dist = leftPair.height + rightPair.height + 1;
        int diameter = Math.max(leftDiameter, Math.max(rightDiameter, dist));

        int height = Math.max(leftPair.height, rightPair.height) + 1;

        return new Pair(diameter, height);
    }

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        Pair pair = diameterHelper(root);
        return pair.diameter;
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

        System.out.print("Diameter of the Tree is: " + diameterOfBinaryTree(root));
        System.out.println();

    
    }
}
