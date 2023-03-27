class Solution {
    
    double ans;
    
    public double myPow(double x, int n) {
        
        if (n == 0){
            
            return 1;
        }
        
        if (n == 1) {
            
            return x;
        }
        
        else if (n == -1) {
            
            return 1/x;
        }
       
        int mid = n/2; 
        ans = myPow(x,mid);
        
        if (n %2 == 0) {
            
            return ans*ans;
            
        }
        
        else {
            
            if (n < 0) {
          
                return ans*ans*(1/x);   
            }
            return ans*ans*x;
        }
    }
}
