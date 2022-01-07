import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int val) {
          this.val = val;
      }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class ValidateBST {
    private static void copyBST(TreeNode root, ArrayList<Integer>list) {
        if(root != null){
            copyBST(root.left, list);
            list.add(root.val);
            copyBST(root.right, list);
        }
    }

    private static boolean checkBST(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        copyBST(root, list);
        for(int i=0; i<list.size()-1; i++){
            if(list.get(i) >= list.get(i+1))
                return false;
        }
        return true;
    }
    public static void main(String [] args){
        TreeNode root = new TreeNode(5);
        TreeNode one = new TreeNode(2);
        TreeNode two = new TreeNode(7);
        TreeNode three = new TreeNode(1);
        TreeNode four = new TreeNode(3);
        TreeNode five = new TreeNode(6);
        TreeNode six = new TreeNode(8);

        root.left = one;
        root.right = two;
        one.left = three;
        one.right = four;
        two.left = five;
        two.right = six;

        // 1. Copy BST
        System.out.println("Is Valid BST :" +  checkBST(root));
    }
}
