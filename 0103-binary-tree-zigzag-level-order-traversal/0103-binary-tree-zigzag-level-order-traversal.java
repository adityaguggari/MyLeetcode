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
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return result;
        
        queue.add(root);
        boolean lefttoright = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentlevel = new ArrayList<>();
            for(int i = 0; i < size ; i++) {
                TreeNode currentNode = queue.remove();
                if(lefttoright == true){
                    currentlevel.add(currentNode.val);
                }
                else {
                    currentlevel.add(0, currentNode.val);
                }
                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            lefttoright = !lefttoright;
            result.add(currentlevel);
        }
        return result;
    }
}