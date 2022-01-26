package com.company.Trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNodeE{
    int val;
    TreeNodeE left;
    TreeNodeE right;
    TreeNodeE(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class ConstructTreeFromPostIn {

    public static void levelOrderTraversal(TreeNodeE root){
        Queue<TreeNodeE> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNodeE currentRoot = queue.poll();
            if(currentRoot != null) {
                System.out.print(currentRoot.val + " ");

                if (currentRoot.left != null) {
                    queue.add(currentRoot.left);
                }
                if (currentRoot.right != null) {
                    queue.add(currentRoot.right);
                }
            }
        }
    }

    public static TreeNodeE helper(int []post, int []in, int sPost, int ePost, int sIn, int eIn){
        if(sPost > ePost || sIn > eIn){
            return null;
        }
        // Find Root
        int rootData = post[ePost];
        TreeNodeE root = new TreeNodeE(rootData);


        // Find Root Index
        int rootIndex = -1;
        for(int i = sIn; i <= eIn; i++){
            if(rootData == in[i]){
                rootIndex = i;
                break;
            }
        }

        int sInLeft = sIn;
        int eInLeft = rootIndex - 1;
        int sInRight = rootData + 1;
        int eInRight = eIn;


        int sPostLeft = sPost;
        int ePostLeft = sPost + (rootIndex - sIn - 1);
        int sPostRight = ePostLeft + 1;
        int ePostRight = ePost - 1;


        TreeNodeE leftSubTree = helper(post , in, sPostLeft, ePostLeft, sInLeft, eInLeft);
        TreeNodeE rightSubTree = helper(post , in, sPostRight, ePostRight, sInRight, eInRight) ;
        root.left = leftSubTree;
        root.right = rightSubTree;
        return root;
    }


    public static TreeNodeE constructTreeFromPostIn(int []post, int[]in){
        return helper(post, in, 0, post.length - 1, 0, in.length - 1);
    }

    public static void inOrder(TreeNodeE root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.val +  " ");
            inOrder(root.right);
        }
    }
    public static void main(String [] args){
        int [] post = {4, 5, 2, 6, 7, 3, 1};
        int [] in = {4, 2, 5, 1, 6, 3, 7};
        TreeNodeE root = constructTreeFromPostIn(post, in);
        levelOrderTraversal(root);
        System.out.println();
        inOrder(root);
    }
}
