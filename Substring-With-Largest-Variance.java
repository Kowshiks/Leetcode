class Solution {
    
    String s;
    
    private int findval(char first, char second) {
        
        int output = 0;
        
        int first_val = 0;
        int second_val = 0;
        
        int first_index = 0;
        
        int second_index = 0;
        
        for(int x=0; x<s.length(); x++) {
                      
            if (s.charAt(x) == first) {

                first_val += 1;
                
            }

            else if (s.charAt(x) == second){

                second_val += 1;

            }

            if (first_val > 0 && second_val > 0) {

                if (second_val > first_val) {

                    if (s.charAt(x) == first) {

                        first_val = 1;

                    }

                    else {
                        
                        if (first_index > second_index) {
                            
                            first_val = 1;
                        }
                            
                        else {
                            
                            first_val = 0;
                        }

                    }

                    second_val = 1;

                }

                output = Math.max(output,first_val - second_val);
            }
            
            if (s.charAt(x) == first) {

                first_index = x;
                
            }

            else if (s.charAt(x) == second){

                second_index = x;

            }

        }
        
        return output;
        
    }
    
    public int largestVariance(String s) {
        
        this.s = s;
        
        int output = 0;

        ArrayList<Character> alph = new ArrayList<>();

        HashSet<Character> cache = new HashSet<>();

        for(int i=0; i < s.length(); i++) {

            if (!cache.contains(s.charAt(i)))  {
                
                cache.add(s.charAt(i));

                alph.add(s.charAt(i));

            }

        }
        
        int[] val = new int[s.length()];
        
        for(int i=0; i< alph.size()-1;i++) {
            
            for(int j=i+1; j<alph.size(); j++) {
                
                char first = alph.get(i);
                char second = alph.get(j);
                                
                output = Math.max(output, findval(first,second));
                output = Math.max(output, findval(second,first));
                
            }
             
        }

        return output;
        
    }
}
