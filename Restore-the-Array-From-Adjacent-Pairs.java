class Solution {
    
    HashMap<Integer, ArrayList<Integer>> cache = new HashMap<>();
    
    int first = 0;
    
    public void addMap(int key,int value){
        
        if (!cache.containsKey(key)){
            
            ArrayList<Integer> tmp = new ArrayList<>();
                        
            tmp.add(value);
            
            cache.put(key,tmp);
            
        }
        
        else {
            
            cache.get(key).add(value);
            
        }
        
    }
    
    public int[] restoreArray(int[][] adjacentPairs) {
        
        int[] output = new int[adjacentPairs.length+1];
        
        for(int[] each: adjacentPairs){
            
            addMap(each[0], each[1]);
            addMap(each[1], each[0]);
            
        }
        
        
        for(Map.Entry<Integer,ArrayList<Integer>> each:cache.entrySet()){
            
            if (each.getValue().size() == 1) {
                
                first = each.getKey();
                
                break;
            }
            
            
            
        }
        
        output[0] = first;
        
        output[1] = cache.get(first).get(0);
        
        int node = output[1];
        
        int index = 2;
        
        while ((index < adjacentPairs.length+1) || (cache.get(node).size() != 1)){
            
            for(int each:cache.get(node)){
                
                if (each != output[index-2]){
                    
                    output[index] = each;
                    
                    node = each;
                    
                }
                
            }
            
            index+=1;
            
        }
        
        return output;
        
    }
}
