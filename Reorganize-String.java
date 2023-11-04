class Solution {
    public String reorganizeString(String s) {
        
        HashMap<Character, Integer> cache = new HashMap<>();
        
        ArrayList<ArrayList<Object>> arr = new ArrayList<>();
        
        for(Character each:s.toCharArray()){
            
            if (!cache.containsKey(each)){
                
                cache.put(each,1);
            }
            
            else {
                
                cache.put(each,cache.get(each)+1);
            }
            
        }
        
        for(Map.Entry<Character,Integer> each:cache.entrySet()){
            
            ArrayList<Object> tmp = new ArrayList<>();
            
            tmp.add(each.getValue());
            
            tmp.add(each.getKey());
            
            arr.add(tmp);

        }
        
        Comparator<List<Object>> maxHeapComparator = (list1, list2) ->
                -Integer.compare((int) list1.get(0), (int) list2.get(0)); 
        
        PriorityQueue<List<Object>> maxHeap = new PriorityQueue<>(maxHeapComparator);
        
        maxHeap.addAll(arr);
        
        String output = "";
                
        List<Object> stack = new ArrayList<>();
        
        while (!maxHeap.isEmpty() || !stack.isEmpty()) {
            
            List<Object> curSide = new ArrayList<>();
            
            if (!stack.isEmpty() && maxHeap.isEmpty()) {
                
                return "";
            }
            
            List<Object> rem = maxHeap.poll();
            
            int cur_rem = (int) rem.get(0)-1;
                
            char cur_char = (char) rem.get(1);
            
            output = output + cur_char;
            
            if (!stack.isEmpty()) {
                
                curSide.add(stack.get(0));
            
                curSide.add(stack.get(1));
                
                maxHeap.add(curSide);
                
                stack = new ArrayList<>();
                
            }
            
            if (cur_rem != 0) {
            
                curSide = new ArrayList<>();

                stack.add(cur_rem);

                stack.add(cur_char);
                
            } 
        }
        
        return output;
    
    }
}
