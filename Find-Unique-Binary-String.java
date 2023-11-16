class Solution {
    
    HashSet<String> cache = new HashSet<>();
    
    int len;
    
    boolean tmp = false;
    
    String output;
    
    public void rec(int index, String node){
        
        if (index == len){
            
            if (!cache.contains(node)){
                
                tmp = true;
                
                output = node;
            }
            
            return;
        }
        
        if (tmp){
            
            return;
            
        }
        
        String node_1 = node;
        
        String node_2 = node;
        
        node_1 += "0";
        
        node_2 += "1";
        
        rec(index+1,node_1);
        
        rec(index+1,node_2);
        
        return;
    }
    
    public String findDifferentBinaryString(String[] nums) {
        
        len = nums[0].length();
        
        for(String each: nums){
            
            cache.add(each);
            
        }
        
        rec(0,"");
        
        return output; 
        
    }
}
