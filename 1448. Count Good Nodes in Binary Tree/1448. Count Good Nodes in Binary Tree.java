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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    public int dfs(TreeNode root, int maxVal){
        if(root == null){
            return 0;
        }
        int opt = 0;
        if(root.val >= maxVal){
            opt = 1;
        }
        opt += dfs(root.left, Math.max(maxVal, root.val));
        opt += dfs(root.right, Math.max(maxVal, root.val));
        return opt;
    }
}