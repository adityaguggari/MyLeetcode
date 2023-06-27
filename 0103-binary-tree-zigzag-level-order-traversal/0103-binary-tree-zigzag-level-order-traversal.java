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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean LeftToRight = true;
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> currentlist = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode current = q.remove();
                if(LeftToRight == true) {
                    currentlist.add(current.val);
                }
                else {
                    currentlist.add(0,current.val);
                }
                
                if(current.left != null) {
                    q.add(current.left);
                }
                if(current.right != null) {
                    q.add(current.right);
                }
            }
            LeftToRight = !LeftToRight;
            result.add(currentlist);
        }
        return result;
    }
}