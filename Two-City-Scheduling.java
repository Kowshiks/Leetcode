class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int[][] cache = new int[costs.length][2];
        
        for(int i=0; i<costs.length; i++) {
            
            int l1 = costs[i][0] - costs[i][1];
            
            int l2 = i;
            
            int[] tmp = new int[2];
            
            tmp[0] = l1;
            
            tmp[1] = l2;
            
            cache[i] = tmp;
            
        }
        
        Arrays.sort(cache, Comparator.comparingInt(a -> a[0]));
        
        int output_1 = 0;
        
        int output_2 = 0;
        
        int index = 0;
        
        while (index < costs.length/2){
            
            output_1 = output_1 + costs[cache[index][1]][1] + costs[cache[costs.length - 1 - index][1]][0];
            output_2 = output_2 + costs[cache[index][1]][0] + costs[cache[costs.length - 1 - index][1]][1];
            
            index +=1;
        }    
        
        return Math.min(output_1,output_2);
        
    }
}
