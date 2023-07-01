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
        int[] result = new int[2];
        helper(root, k, result);
        return result[1];
    }
    
    void helper(TreeNode root, int k, int[] result) {
        if(root == null) return;
        
        helper(root.left, k, result);
        if(++result[0] == k) {
            result[1] = root.val;
            return;
        }
        helper(root.right, k, result);
    }
}