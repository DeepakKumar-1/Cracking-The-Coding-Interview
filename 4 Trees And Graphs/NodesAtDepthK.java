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

public class NodesAtDepthK {
    public static <T>BinaryTreeNode<T> createNode(T val){
        return new BinaryTreeNode<>(val);
    }

    public static void printNodesAtDepthK(BinaryTreeNode<Integer> root, int k){
        if(root == null){
            return;
        }
        if(k == 0){
                System.out.print(root.val + " ");
                return;
        }
        printNodesAtDepthK(root.left, k-1);
        printNodesAtDepthK(root.right, k-1);
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
        int res = largest(root);

        printNodesAtDepthK(root, 2);
    }
}
