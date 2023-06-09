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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        TreeNode curr=root;
        TreeNode prev;
        while(curr!=null) {
            if(curr.left==null) {
                result.add(curr.val);
                curr=curr.right;
            }
            else {
                prev=curr.left;
                while(prev.right!=null && prev.right!=curr) {
                    prev=prev.right;
                }
                if(prev.right==null) {
                    prev.right=curr;
                    curr=curr.left;
                }
                else {
                    prev.right=null;
                    result.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        return result;
    }
}