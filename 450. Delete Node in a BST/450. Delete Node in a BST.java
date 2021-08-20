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
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfs(root, key);
    }
    public TreeNode dfs(TreeNode root, int key){
        if(root==null){
            return null;
        }
        if(root.val == key){
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            TreeNode successor = ans(root.right);
            root.val = successor.val;
            successor.val = key;
            root.right = dfs(root.right, key);
            return root;
        }
        if(key <= root.val){
            root.left = dfs(root.left, key);
        }
        else{
            root.right = dfs(root.right, key);
        }
        return root;
    }
    public TreeNode ans(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
}
