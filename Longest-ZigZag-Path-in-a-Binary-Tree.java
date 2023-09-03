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
    
    int output = 0;
    
    private void rec(TreeNode node, int count, char path){
        
        if (node == null){
            
            return;
            
        }
        
        output = Math.max(output,count);
        
        if (path == 'r') {
            
            rec(node.left,count+1,'l');
            rec(node.right,1,'r');
            
        }
        
        else if (path == 'l') {
            
            rec(node.left,1,'l');
            rec(node.right,count+1,'r');
            
        }
        
        else {
            
            rec(node.left,1,'l');
            rec(node.right,1,'r');
            
        }
        
    }
    
    public int longestZigZag(TreeNode root) {
        
        rec(root,0,'c');
        
        return output;
        
    }
}
