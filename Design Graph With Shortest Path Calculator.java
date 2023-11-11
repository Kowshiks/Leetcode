class Graph {
    
    HashMap<Integer,ArrayList<int[]>> cache = new HashMap<>();
    
    public void addKeyVal(int from, int to, int val){
        
        if (!cache.containsKey(from)){
                
                ArrayList<int[]> tmp = new ArrayList<>();
                
                int[] tmp_int = new int[2];
                
                tmp_int[1] = to;
                
                tmp_int[0] = val;
                
                tmp.add(tmp_int);
                
                cache.put(from,tmp);
                
            }
            
            else {
                
                int[] tmp_int = new int[2];
                
                tmp_int[1] = to;
                
                tmp_int[0] = val;
                
                cache.get(from).add(tmp_int);
                
            }
        
    }
    
    public Graph(int n, int[][] edges) {
        
        for(int[] edge: edges) {
            
            int from = edge[0];
            
            int to = edge[1];
            
            int val = edge[2];
            
            addKeyVal(from,to,val);
            
        }
        
    }
    
    public void addEdge(int[] edge) {
        
        int from = edge[0];
            
        int to = edge[1];

        int val = edge[2];

        addKeyVal(from,to,val);
        
        
    }
    
    public int shortestPath(int node1, int node2) {
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        
        HashMap<Integer,Integer> visited = new HashMap<>();
                
        int[] tmp = new int[2];
        
        tmp[0] = 0;
        
        tmp[1] = node1;
        
        heap.add(tmp);
        
        visited.put(node1,0);
        
        while (!heap.isEmpty()){
            
            int[] cur = heap.poll();
            
            int val = cur[0];
            
            int nodeVal = cur[1];
            
            if (nodeVal == node2){
                
                return val;
            }
                        
            if (cache.containsKey(nodeVal)){
            
                for(int[] each:cache.get(nodeVal)){

                    if ((!visited.containsKey(each[1])) || (each[0]+val < visited.get(each[1]))){

                        int[] cur_tmp = new int[2];

                        cur_tmp[0] = each[0]+val;

                        cur_tmp[1] = each[1];
                        
                        heap.add(cur_tmp);

                        visited.put(each[1],each[0]+val);

                    }

                }
                
            }
                        
        }
        
        return -1;
        
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
