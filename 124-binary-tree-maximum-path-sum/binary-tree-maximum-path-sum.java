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
    public int maxPathSum(TreeNode root) {
        pathsum(root);
        return ans;
    }
    int ans=Integer.MIN_VALUE;
    public int pathsum(TreeNode root){
        if(root==null){
            return 0;
            
        }
        // compute max path sum without split
        int left = Math.max(0, pathsum(root.left));
        int right = Math.max(0, pathsum(root.right));
        
        // compute max path sum with split
        ans = Math.max(ans, left+right+root.val);

        return Math.max(left, right)+root.val;
    }
}