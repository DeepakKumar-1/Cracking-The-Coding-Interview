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
public class MinimalTree {
    public static TreeNode createMinimalBST(int [] arr, int start, int end){
        //Base Case
        if(start > end){
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = createMinimalBST(arr, start, mid-1);
        node.right = createMinimalBST(arr, mid+1, end);
        return node;
    }
    public static TreeNode createMinimalBST(int [] array){
        return createMinimalBST(array, 0, array.length-1);
    }


    private static void inOrder(TreeNode root) {
        if(root != null){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public static void main(String [] args){
        int [] arr = {-10,-3,0,5,9};
        TreeNode root = createMinimalBST(arr);
       // System.out.println(root.val);
        // Traverse the Tree
        inOrder(root);
    }

}


//    -10 -3 0 5 9
