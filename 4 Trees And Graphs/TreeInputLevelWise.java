
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


public class TreeInputLevelWise{

    public static BinaryTreeNode<Integer> treeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Root Data: ");
        int rootData = sc.nextInt();
        if(rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> root1 = queue.poll();
            // Take Left Input
            System.out.print("Enter Left Data: ");
            int leftData = sc.nextInt();
            if(leftData ==  -1){
                root1.left = null;
            }else{
                root1.left = new BinaryTreeNode<>(leftData);
                queue.add(root.left);
            }
            System.out.print("Enter right Data: ");
            int rightData = sc.nextInt();
            if(rightData ==  -1){
                root1.right = null;
            }else{
                root1.right = new BinaryTreeNode<>(leftData);
                queue.add(root.right);
            }
        }
        return root;
    }

     public static void main(String []args){
     BinaryTreeNode root = takeInputLevelWise();
     }
}
