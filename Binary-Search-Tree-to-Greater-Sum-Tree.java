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
    
    TreeNode root = new TreeNode();
    
    int great_sum = 0;
    
    private void rec(TreeNode node){
        
        
        if (node == null){
            
            return;
        }
        
        rec(node.right);
        
        node.val = node.val + great_sum;
        
        great_sum = node.val;
        
        rec(node.left);
     
    }
    
    public TreeNode bstToGst(TreeNode root) {
        
        this.root  = root;
        
        rec(root);
        
        return root;
        
    }
}
