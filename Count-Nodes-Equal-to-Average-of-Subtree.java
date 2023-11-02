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
    
    public ArrayList<Integer> rec(TreeNode node) {
        
        if (node == null) {
            
            ArrayList<Integer> tmp = new ArrayList<>();
            
            tmp.add(0);
            tmp.add(0);
            
            return tmp;
        }
        
        ArrayList<Integer> left = rec(node.left);
        
        ArrayList<Integer> right = rec(node.right);
        
        int sum_val = node.val + left.get(0) + right.get(0);
        
        int len = 1+left.get(1)+right.get(1);
        
        if (sum_val / len == node.val){
            
            output+=1;
            
        }
        
        ArrayList<Integer> tmp = new ArrayList<>();
        
        tmp.add(sum_val);
        
        tmp.add(len);
        
        return tmp;
        
    }
    
    public int averageOfSubtree(TreeNode root) {
        
        ArrayList<Integer> ans = rec(root);
        
        return output;
        
    }
}
