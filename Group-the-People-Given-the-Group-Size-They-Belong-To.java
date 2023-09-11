class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        HashMap<Integer,ArrayList<Integer>> cache = new HashMap<>();
        
        List<List<Integer>> output = new ArrayList<>();
        
        ArrayList<Integer> node = new ArrayList<>();
        
        for (int i=0 ; i< groupSizes.length; i++) {
            
            if (!cache.containsKey(groupSizes[i])){
                
                node = new ArrayList<>();
                
                node.add(i);
                
                cache.put(groupSizes[i],node);
                
            }
            
            else {
                
                cache.get(groupSizes[i]).add(i);
                
            }
        }
        
        
        for(Map.Entry<Integer,ArrayList<Integer>> entry: cache.entrySet()) {
            
            node = new ArrayList<>();
            
            ArrayList<Integer> val = entry.getValue();
            
            int groupSize = entry.getKey();
            
            int tmp = 0;
            
            while (!val.isEmpty()) {
                
                tmp+=1;
                
                int cur = val.remove(val.size()-1);
                
                node.add(cur);
                
                if (tmp == groupSize) {
                                        
                    tmp = 0;
                    
                    output.add(node);
                    
                    node = new ArrayList<>();
                    
                }
                
            }
            
        }
        
        return output;
    }
}
