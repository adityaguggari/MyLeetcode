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
    public void flatten(TreeNode root) {
    TreeNode curr = root;
    while(curr!=null) {
        if(curr.left !=null)
        {
        TreeNode prev = curr.left;
        while(prev.right != null) {
            prev = prev.right;
        }
        prev.right=curr.right;
        curr.right=curr.left;
        curr.left = null;
        }
        curr=curr.right;
    }
    }
}      

//        if(root == null) return;
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);
        
//         while(!stack.isEmpty()) {
//             TreeNode current = stack.pop();
//             if(current.right!=null) {
//                 stack.push(current.right);
//             } 
//             if(current.left!=null) {
//                 stack.push(current.left);
//             }
//             if(!stack.isEmpty()) {
//                 current.right = stack.peek();
//             }
//             current.left = null;
//        }
//     }
// }