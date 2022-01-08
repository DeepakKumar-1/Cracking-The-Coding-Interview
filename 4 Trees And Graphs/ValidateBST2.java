//  Definition for a binary tree node.
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

public class ValidateBST2 {
    static boolean checkBST(TreeNode root, Integer min, Integer max){
        if(root == null)
            return true;
        if((min != null && root.val <= min)||(max != null && root.val > max)){
            return false;
        }
        if(!checkBST(root.left, min, root.val) || !checkBST(root.right, root.val, max)){
            return false;
        }
        return true;
    }

   static boolean checkBST(TreeNode root){
        return checkBST(root, null, null);
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

        System.out.println("Is Valid BST: " + checkBST(root));
    }

}
