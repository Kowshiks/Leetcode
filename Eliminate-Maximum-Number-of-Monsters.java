class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        
        int[] cache = new int[dist.length];
        
        for(int i=0; i<dist.length; i++) {
            
            int tmp = dist[i]/speed[i];
            
            int rem = dist[i]%speed[i];
            
            if (rem > 0) {
                
                tmp+=1;
                
            }
        
            cache[i] = tmp;
            
        }
        
        Arrays.sort(cache);
        
        int output = 0;
        
        int count = cache[0];
        
        System.out.println(Arrays.toString(cache));
        
        while (output < dist.length-1){
            
            if (cache[output] == cache[output+1] && count <= 1) {
                
                
                break;
            }
            
            else if (cache[output] == cache[output+1]){
                
                count-=1;
            }
            
            else {
                
                count+= cache[output+1] - cache[output] - 1;
                
            }
            
            output+=1;
            
            
        }
        
        return output+1;
        
    }
}
