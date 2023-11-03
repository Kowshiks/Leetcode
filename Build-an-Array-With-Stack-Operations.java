class Solution {
    public List<String> buildArray(int[] target, int n) {
        
        List<String> output = new ArrayList<>();
        
        int index = 0;
        
        for(int i=1;i<=n;i++) {

            output.add("Push");
            
            if (target[index] == i){
                
                index+=1;
                
            }
            
            else {
                
                output.add("Pop");
                
            }
            
            if (index >= target.length){
                
                break;
            }
            
        }

        return output;
        
    }
}
