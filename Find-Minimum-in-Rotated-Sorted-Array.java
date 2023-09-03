class Solution {
    public int findMin(int[] nums) {
        
        int l = 0;
        int r = nums.length-1;
        
        int mid = (l+r)/2;
        
        while (l<r) {
            
            mid = (l+r)/2;
                
            if (nums[l] < nums[mid]) {
                
                if (nums[r] > nums[l]) {
                    
                    return nums[0];
                }
                
                else {
                    
                    l = mid;   
                }
            }
            else {
                
                r = mid;
            }
            
        }
        
        if ((mid + 1 < nums.length) && (nums[mid+1] < nums[mid])) {
            
            return nums[mid+1];
        }
        
        if ((mid -1 >= 0) && (nums[mid-1] < nums[mid])) {
            
            return nums[mid-1];
        }
        
        return nums[mid];
        
    }
}
