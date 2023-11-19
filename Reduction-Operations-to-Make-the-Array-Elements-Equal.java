class Solution {
    public int reductionOperations(int[] nums) {
        
        Arrays.sort(nums);
        
        int val = 0;
        
        for(int i= nums.length-2; i>=0;i--){
            
            if (nums[i] < nums[i+1]) {
                
                val += nums.length - i - 1; 
                
            }
            
        }
        
        return val;
        
    }
}
