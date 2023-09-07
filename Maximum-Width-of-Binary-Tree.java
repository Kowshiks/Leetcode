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
    public int widthOfBinaryTree(TreeNode root) {
        
        ArrayList<ArrayList<Object>> fringe = new ArrayList<>();
        
        ArrayList<Object> cur = new ArrayList<>();
        
        cur.add(root);
        
        cur.add(1);
        
        fringe.add(cur);
                        
        int output = 1;
        
        while (!fringe.isEmpty()) {
                        
            ArrayList<Integer> cache = new ArrayList<>();
            
            ArrayList<ArrayList<Object>> node_fringe = new ArrayList<>();
            
            
            for (int i = 0; i< fringe.size(); i++) {
                
                cur = fringe.get(i);
                
                TreeNode node = (TreeNode) cur.get(0);
                
                int pos = (int) cur.get(1);
                
                if (node.left != null) {
                    
                    cur = new ArrayList<>();
                    
                    cur.add(node.left);
                    
                    cur.add(pos*2);
                    
                    node_fringe.add(cur);
                    
                    cache.add(pos*2);
                    
                }
                
                if (node.right != null) {
                    
                    cur = new ArrayList<>();
                    
                    cur.add(node.right);
                    
                    cur.add((pos*2)+1);
                    
                    node_fringe.add(cur);
                    
                    cache.add((pos*2)+1);
                    
                }  
                
            }
            
            if (cache.size() > 0) {
            
                output = Math.max(output, (cache.get(cache.size()-1) - cache.get(0) + 1));
                
            }
            
            fringe = node_fringe;
            
        }
        
        return output;
        
    }
}
