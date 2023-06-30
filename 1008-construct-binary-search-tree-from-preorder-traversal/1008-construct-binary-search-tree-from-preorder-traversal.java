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
    public TreeNode bstFromPreorder(int[] preorder) {
       return helper(preorder, new int[]{0}, Integer.MAX_VALUE);
    }
    
    TreeNode helper(int[] preorder, int[] i, int bound) {
        if(i[0] > preorder.length-1 || preorder[i[0]] > bound) return null;
        
        TreeNode root = new TreeNode(preorder[i[0]]);
        i[0]++;
        root.left = helper(preorder, i, root.val);
        root.right = helper(preorder, i , bound);
        return root;
        
    }
}

