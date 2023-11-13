class Solution {
    public String sortVowels(String s) {
        
        ArrayList<Character> vowels = new ArrayList<>();
        
        ArrayList<String> index = new ArrayList<>();
        
        HashSet<Character> cache = new HashSet<>();
        
        cache.add('A');
        cache.add('E');
        cache.add('I');
        cache.add('O');
        cache.add('U');
        cache.add('a');
        cache.add('e');
        cache.add('i');
        cache.add('o');
        cache.add('u');
        
        String tmp = "";
        
        for(int i=0 ; i< s.length(); i++){
            
            if (cache.contains(s.charAt(i))){
                
                index.add(tmp);
                
                if (!tmp.isEmpty()){
                    
                    String cur = "";
                    
                    index.add(cur);
                    
                }
                
                tmp = "";
                
                vowels.add(s.charAt(i));
                                
            }
            
            else{
                
                tmp+=s.charAt(i);
                
            }
            
        }
        
        if (!tmp.isEmpty()){
            
            index.add(tmp);
            
        }
        
        Collections.sort(vowels);
        
        String output = "";
        
        int cur_val = 0;
        
        for(int each=0; each < index.size(); each++) {
            
            if (index.get(each).isEmpty()){
                
                index.set(each,String.valueOf(vowels.get(cur_val)));
                
                cur_val+=1;
                
            }
            
            output = output + index.get(each);
            
        }
        
        return output;
        
    }
}
