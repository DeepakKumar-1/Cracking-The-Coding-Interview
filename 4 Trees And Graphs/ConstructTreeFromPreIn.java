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

public class ConstructTreeFromPreIn {

     public static void levelOrderTraversal(BinaryTreeNode<Integer> root){
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

       // Construct Tree Using InOrder and Preorder Traversal
    public static BinaryTreeNode<Integer> helper(int []pre, int []in, int sPre, int ePre, int sIn, int eIn){
        if(sPre > ePre){
            return null;
        }
        int rootData = pre[sPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        int indexOfRoot =  -1;
        for(int index = sIn; index <= eIn; index++){
            if(in[index] == rootData){
                indexOfRoot = index;
                break;
            }
        }

        int sPreLeft = sPre + 1;
        int sInLeft = sIn;
        int ePreRight = ePre;
        int eInRight = eIn;
        int sInRight = indexOfRoot + 1;
        int eInLeft = indexOfRoot - 1;
        int ePreLeft = sPreLeft + (eInLeft - sInLeft + 1);
        int sPreRight = ePreLeft + 1;


        BinaryTreeNode<Integer>  left = helper(pre, in, sPreLeft, ePreLeft,sInLeft, eInLeft);
        BinaryTreeNode<Integer>  right = helper(pre, in, sPreRight, ePreRight,sInRight, eInRight);
        root.left = left;
        root.right = right;
        return root;
    }
    public static BinaryTreeNode<Integer> constructTreeFromPreIn(int []pre, int []in){
        BinaryTreeNode<Integer> root = helper(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return root;
    }

    public static void inOrder(BinaryTreeNode<Integer> root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.val +  " ");
            inOrder(root.right);
        }
    }
    public static void main(String [] args){
       int []pre = {1, 2, 4, 5, 3, 6, 7};
        int []in = {4, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode<Integer> root = constructTreeFromPreIn(pre, in);
        inOrder(root);
        System.out.println();
        levelOrderTraversal(root);
    }
}
