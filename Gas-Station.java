class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int tmp = 0;
        int index = 0;
        
        for(int i=0; i< gas.length; i++) {
            
            tmp += gas[i] - cost[i];
            
            if (tmp < 0){
                
                index = i+1;
                tmp = 0;
            }
            
        }
        
        for (int j=0; j < index;j++) {

            tmp+= gas[j]-cost[j];

            if (tmp < 0) {

                return -1;
            }

        }

        return index;
    }
}
