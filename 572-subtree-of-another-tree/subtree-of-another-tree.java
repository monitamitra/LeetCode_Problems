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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return isSubTree(root, subRoot);
    }

    private boolean isSubTree(TreeNode tree, TreeNode subTree) {
        if (tree == null) {
            return false;
        }
        
        if (tree.val == subTree.val) {
            if (helper(tree, subTree)) {
                return true;
            }
        }
        return isSubTree(tree.right, subTree) || isSubTree(tree.left, subTree);
    }

    private boolean helper(TreeNode tree, TreeNode subTree) {
       if (subTree == null && tree == null) {
            return true;
        }

        if (subTree == null || tree == null || tree.val != subTree.val) {
            return false;
        }

        return helper(tree.right, subTree.right) && helper(tree.left, subTree.left);
    }
}