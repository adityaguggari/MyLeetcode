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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length-1,
             postorder, 0, postorder.length-1);
    }
    
    public TreeNode build(int[] inorder, int inStart, int inEnd,
                         int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        int inIndex = 0;
        for(int i = inStart; i<=inEnd ; i++) {
            if(root.val == inorder[i]) {
                inIndex = i;
            }
        }
        
        root.left = build(inorder, inStart, inIndex - 1, postorder, postStart, postStart + inIndex - inStart - 1);
        root.right = build(inorder, inIndex + 1, inEnd, postorder, postStart + inIndex - inStart, postEnd -1);
            
        return root;
    }
}