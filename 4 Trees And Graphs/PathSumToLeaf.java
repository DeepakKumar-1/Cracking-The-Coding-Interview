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

public class PathSumToLeaf {

    public static void pathSumToLeaf(BinaryTreeNode<Integer> root, String str ,int sum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(sum == root.val){
                System.out.println(str + " -> " + root.val);
            }
        }
        pathSumToLeaf(root.left, str + " -> " + root.val, sum - root.val);
        pathSumToLeaf(root.right, str + " -> " + root.val, sum - root.val);
    }
    
    
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

    
    public static void main(String [] args){
        BinaryTreeNode<Integer> root, n1, n2, n3, n4, n5, n6, n7, n8;
        root = createNode(0);
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
        levelOrderTraversal(root);

        pathSumToLeaf(root, "" , 37);
    }
}
