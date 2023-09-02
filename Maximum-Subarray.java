class Solution {
    public int maxSubArray(int[] nums) {
        
        int output = Integer.MIN_VALUE;
        
        for(int each: nums) {
            
            output = Math.max(output,each);
        }
        
        int tot = 0;
        
        for(int i=0; i < nums.length; i++) {
            
            if (tot+nums[i] <= 0) {
                
                tot = 0;
            }
            
            else {
                
                tot += nums[i];
                
                output = Math.max(output,tot);
            }
            
        }
        
        return output;
        
    }
}
