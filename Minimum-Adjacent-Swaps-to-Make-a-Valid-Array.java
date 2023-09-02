class Solution {
    public int minimumSwaps(int[] nums) {

        int max_val = 0;
        int min_val = 0;
        
        for(int i=1 ; i< nums.length; i++) {

            if (nums[i] < nums[min_val]) {

                min_val = i;

            }

            if (nums[i] >= nums[max_val]) {

                max_val = i;
            }

        }

        if (min_val < max_val) {

            return min_val + (nums.length - max_val - 1);
        
        }

        if (min_val > max_val) {

            return min_val + (nums.length - max_val - 1) - 1;

        }

        return 0;
        
    }
}
