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
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> st = new Stack<>();
        TreeNode temp = root;

        while (temp != null || !st.isEmpty()) {
            // start from left most subtree...
            while (temp != null) {
                st.push(temp);
                temp = temp.left;
            }
            // went too far left, make temp = most recent treenode...
            temp = st.pop();
            count++;
            if (count == k) {
                return temp.val;
            }
            // allowed to process right subtree now...
            temp = temp.right;
        }

        return -1;
    }
}