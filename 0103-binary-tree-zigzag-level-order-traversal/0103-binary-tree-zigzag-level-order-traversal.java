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
        
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean LefttoRight = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentlevel = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode current = queue.remove();
                if(LefttoRight==true) {
                    currentlevel.add(current.val);
                }
                else {
                    currentlevel.add(0, current.val);
                }
                if(current.left!=null) {
                    queue.add(current.left);
                }
                if(current.right!=null) {
                    queue.add(current.right);
                }
            }
            LefttoRight = !LefttoRight;
            result.add(currentlevel);
        }
        return result;
    }
}