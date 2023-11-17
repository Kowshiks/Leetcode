class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        HashMap<Integer,ArrayList<Integer>> cache = new HashMap<>();
        
        int root = 0;
        
        for (int i=0 ; i<manager.length; i++){
            
            if (manager[i] == -1){
                
                root = i;
            }
            
            else if (!cache.containsKey(manager[i])){
                
                ArrayList<Integer> tmp = new ArrayList<>();
                
                tmp.add(i);
                
                cache.put(manager[i],tmp);
                
            }
            
            else {
                
                cache.get(manager[i]).add(i);
                
            }
            
        }
        
        int output = 0;
        
        ArrayList<int[]> fringe = new ArrayList<>();
        
        int[] cur = {root,0};
        
        fringe.add(cur);
        
        while (!fringe.isEmpty()){
            
            int[] node = fringe.remove(fringe.size()-1);
            
            int key = node[0];
            int val = node[1];
            
            output = Math.max(output,val);
            
            if (cache.containsKey(key)){
                
                for(int each : cache.get(key)){
                    
                    int[] curVal = {each,val+informTime[key]};
                    
                    fringe.add(curVal);
                    
                }
                
            }
            
        }
        
        return output;
        
    }
}
