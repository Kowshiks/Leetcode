class Solution {
    public int countHomogenous(String s) {
        
        int modulo = (int) Math.pow(10,9)+7;
        
        HashMap<String,Integer> cache = new HashMap<>();
        
        int index = 0;
        
        while (index < s.length()){
            
            String node = String.valueOf(s.charAt(index));
            
            int tmp = index+1;
            
            while ((tmp < s.length()) && (s.charAt(index) == s.charAt(tmp))){
                
                node+=s.charAt(index);
                
                tmp+=1;
                
            }
            
            if (!cache.containsKey(node)){
                
                cache.put(node,1);
                
            }
            
            else{
                
                cache.put(node,cache.get(node)+1);
            }
            
            index = tmp;
            
        }
        
        long output = 0; 
        
        for(Map.Entry<String,Integer> each: cache.entrySet()){
            
            long length = each.getKey().length();
            
            output = (output + (((length * (length + 1)) / 2) * each.getValue()) % modulo) % modulo;
            
        }
        
        return (int) output;
        
    }
}
