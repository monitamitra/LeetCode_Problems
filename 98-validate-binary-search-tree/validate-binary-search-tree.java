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
    public boolean isValidBST(TreeNode root) {
        return helper(Long.MIN_VALUE, root, Long.MAX_VALUE);
    }

    private boolean helper(long min, TreeNode temp, long max) {
        if (temp == null) {
            return true;
        }

        if (temp.val <= min || temp.val >= max) {
            return false;
        }

        return helper(min, temp.left, temp.val) && 
        helper(temp.val, temp.right, max);
    }
}