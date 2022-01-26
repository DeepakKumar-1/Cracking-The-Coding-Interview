package com.company.Trees;

class BalanceTreeReturn{
    int height;
    boolean balanced;
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
public class IsBalanced{

    public static BalanceTreeReturn isBalanced(BinaryTreeNode<Integer> root){
        // Base Case
        if(root == null){
            int height = 0;
            boolean isBal = true;
            BalanceTreeReturn ans = new BalanceTreeReturn();
            ans.height = height;
            ans.balanced = isBal;
            return ans;
        }
        BalanceTreeReturn leftOut = isBalanced(root.left);
        BalanceTreeReturn rightOut = isBalanced(root.right);
        boolean isBal = true;
        int height = 1 + Math.max(leftOut.height, rightOut.height);
        if(Math.abs(leftOut.height - rightOut.height) > 1){
            isBal = false;
        }
        if(!leftOut.balanced || !rightOut.balanced){
            isBal = false;
        }
        BalanceTreeReturn ans = new BalanceTreeReturn();
        ans.height = height;
        ans.balanced = isBal;
        return ans;
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
      
        BalanceTreeReturn ans1 = isBalanced(root);
        System.out.println("Is Balanced: "  + ans1.balanced + " Height is: " + ans1.height);
    }
}
