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

public class GetRootToNodePath {
  
      public static <T>BinaryTreeNode<T> createNode(T val){
        return new BinaryTreeNode<>(val);
    }


    public static ArrayList<Integer> getRootToNodePath(BinaryTreeNode<Integer> root, int data){
        if(root == null){
            return null;
        }

        if(root.val == data){
            ArrayList<Integer> output = new ArrayList<>();
            output.add(data);
            return output;
        }

        ArrayList<Integer> leftOutput = getRootToNodePath(root.left, data);
        if(leftOutput != null){
            leftOutput.add(root.val);
            return leftOutput;
        }

        ArrayList<Integer> rightOutput = getRootToNodePath(root.right, data);
        if(rightOutput != null){
            rightOutput.add(root.val);
            return rightOutput;
        }else{
            return null;
        }
    }


    public static void main(String []args){
        BinaryTreeNode<Integer> root, n1, n2, n3, n4, n5, n6, n7, n8;
        root = createNode(50);
        n1 = createNode(30);
        n2 = createNode(55);
        n3 = createNode(1);
        n4 = createNode(25);
        n5 = createNode(14);
        n6 = createNode(4);
        n7 = createNode(9);
        n8 = createNode(13);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        n4.left = n6;
        n4.right = n7;
        n5.left = n8;

        System.out.println("Root to Node path: " + getRootToNodePath(root, 13));
    }
}
