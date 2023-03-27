class Solution {
    public int maximalSquare(char[][] matrix) {
        
        
        int rows = matrix.length;
        
        int cols = matrix[0].length;
        
        String[][] cur_str = new String[rows][cols];
        
        
        for( int k  = 0; k<rows; k++) {
            
            for ( int z = 0; z < cols; z++) {
                
                cur_str[k][z] = String.valueOf(matrix[k][z]);
    
            }
        }
        
        int output = Integer.MIN_VALUE;
       
        for (int i = rows-1; i >= 0; i--) {
            
            for(int j = cols-1; j >= 0; j--) {
                
                if (cur_str[i][j].equals("1")) {
                 
                    output = Math.max(output,1);
                    
                }
                
                if (!cur_str[i][j].equals("0")) {
                    
                    if ((i+1 < rows) && (j+1 < cols)) {  
                        
                        int val_right = Integer.parseInt(cur_str[i+1][j]);
                        
                        int val_left = Integer.parseInt(cur_str[i][j+1]);
                        
                        int val_across = Integer.parseInt(cur_str[i+1][j+1]);
                        
                        int val = Math.min(Math.min(val_right,val_left), val_across);
                        
                        if ((val_right == 0) || (val_right == 0) || (val_across == 0)) {
                            
                            val = 0;
                            
                        }
                        
                        else if (val != 0) {
                            
                            cur_str[i][j] = Integer.toString(val+1);
                            
                        }
                        
                        output = Math.max(output,Integer.parseInt(cur_str[i][j]));
                        
                    }
                    
                }     
                
            }   
        }
        return output*output;
        
    }
}
