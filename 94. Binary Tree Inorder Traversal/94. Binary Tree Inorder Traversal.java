/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if(root==null){
            return new LinkedList<>();
        }
        
        stack.add(root);
        while(!stack.isEmpty()){
            while(root.left!=null){
                stack.add(root.left);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            while(root.right==null && !stack.isEmpty()){
                root = stack.pop();
                list.add(root.val);
            }            
            if(root.right!=null){
                stack.add(root.right);
                root = root.right;
            }
        }
        return list;
    }
}
