/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode p;
    
    TreeNode q;
    
    TreeNode output;
    
    public boolean rec(TreeNode node) {
        
        if (node == null){ 
        
            return false;
            
        }
        
        boolean left = rec(node.left);
        
        boolean right = rec(node.right);
        
        if ((left && right) || (left && (node == p || node ==q)) || (right && (node==p || node == q))){
            
            output = node;
            
        }
                
        if (((node.val == p.val) || (node.val == q.val)) || (left || right)) {
            
            return true;
            
        }
        
        return false;
        
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        this.p = p;
        
        this.q = q;
        
        output = root;
        
        rec(root);
        
        return output;
        
    }
}
