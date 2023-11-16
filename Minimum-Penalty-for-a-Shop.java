class Solution {
    public int bestClosingTime(String customers) {
        
        int[] right = new int[customers.length()];
        
        int[] left = new int[customers.length()];
        
        int start = 0;
        
        int end = customers.length()-1;
        
        int left_max_val = 0;
        
        int right_max_val = 0;
        
        while (start < customers.length()){
            
            if (customers.charAt(start) == 'Y'){
                
                left[start] = left_max_val;
                
            }
            
            else {
                
                left_max_val +=1;
                
                left[start] = left_max_val;
            
            }
            
            if (customers.charAt(end) == 'N'){
                
                right[end] = right_max_val;
                
            }
            
            else {
                
                right_max_val +=1;
                
                right[end] = right_max_val;
            
            }
            
            start+=1;
            end-=1;
            
        }
        
        int output = right[0];
        
        int index = 0;
        
        for(int i=1; i< right.length;i++){
            
            int val = right[i] + left[i-1];
            
            if (val < output){
                
                index = i;
                
                output = val;
                
            }
                        
        }
        
        if (left[left.length-1] < output){
            
            return left.length;
        }
        
        return index;
        
    }
}
