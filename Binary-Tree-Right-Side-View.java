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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> output = new ArrayList<>();
        
        if (root == null) {
            
            return output;
        }
        
        
        HashMap<Integer, Integer> cache = new HashMap<>();
        
        ArrayList<Object[]> fringe = new ArrayList<>();
        
        Object[] cur = new Object[2];
        
        Object[] tmp_node = new Object[2];
        
        cur[0] = root;
        
        cur[1] = 0;
        
        fringe.add(cur);
                
        while (!fringe.isEmpty()) {
            
            cur = fringe.remove(0);
            
            TreeNode node = (TreeNode) cur[0];
                        
            int level = (int) cur[1];
            
            cache.put(level,node.val);
         
            
            if (node.left != null) {
                
                
                Object[] cur_1 = new Object[2];
                
                cur_1[0] = node.left;
                
                cur_1[1] = level+1;
                
                
                fringe.add(cur_1);
                
            }
            
            if (node.right != null) {
                
                Object[] cur_2 = new Object[2];
                
                cur_2[0] = node.right;
                
                cur_2[1] = level+1;
                
                fringe.add(cur_2);
                
            }             
            
        }
        
        int size = cache.size();
                
        
        for(int i = 0; i < size;i++) {
            
            int ans = cache.get(i);
            
            output.add(ans);
            
        }
        
        return output;
        
    }
}
