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
    int ans = 0;
    public int countNodes(TreeNode root) {
        int a = height(root);
        if(a==-1){
            return 0;
        }
        ans += (1<<a) - 1;
        ans(root);
        return ans;
    }
    public void ans(TreeNode root){
        if(root==null){
            return;
        }
        int a = height(root.left);
        int b = height(root.right);
    
        if(a==b){
            if(a==-1){
                ans++;
                return;
            }
            ans += 1<<a;
            ans(root.right);
        }
        else{
            ans(root.left);
        }   
    }   
    public int height(TreeNode root){
        if(root==null){
            return -1;
        }
        int opt = 0;
        opt = Math.max(opt, 1 + height(root.left));
        opt = Math.max(opt, 1 + height(root.right));
        return opt;
    }
}
