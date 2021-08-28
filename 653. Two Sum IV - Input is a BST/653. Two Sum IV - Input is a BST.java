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
    ArrayList<Integer> arr = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        int n = arr.size();
        for(int i = 0,j = n - 1; i < n;){
            if(i >= j){
                break;
            }
            if(arr.get(i) + arr.get(j) > k){
                j--;
            }
            else if(arr.get(i) + arr.get(j) < k){
                i++;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        arr.add(root.val);
        dfs(root.right);
    }
}