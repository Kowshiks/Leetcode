class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        boolean[] cache = new boolean[3];
        
        for(int[] each:triplets){
            
            if (each[0] == target[0] && (each[1] <= target[1] && each[2] <= target[2])){
                
                cache[0] = true;
                
            }
            
            if (each[1] == target[1] && (each[0] <= target[0] && each[2] <= target[2])){
                
                cache[1] = true;
                
            }
            
            if (each[2] == target[2] && (each[1] <= target[1] && each[0] <= target[0])){
                
                cache[2] = true;
                
            }
            
        }
        
        for(boolean tmp:cache){
            
            if (tmp == false){
                
                return false;
            }
            
        }
        
        return true;
            
        
    }
}
