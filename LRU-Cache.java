public class Node{
    
    int key;
    int val;
    Node right;
    Node left;
    
    Node(int key, int val) {
        
        this.key = key;
        this.val = val;
        
    }
    
}

class LRUCache {
    
    int capacity;
    
    int count = 0;
    
    Node first;
    
    Node last;
    
    HashMap<Integer,Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        
        this.capacity = capacity;  
        
        first = new Node(0,0);
        
        last = new Node(0,0);
        
        first.right = last;
        
        last.left = first;
        
    }
    
    public void remove(Node cur_node) {
        
        Node tmp = cur_node.right;
            
        cur_node.left.right = cur_node.right;
        
        tmp.left = cur_node.left;
    
    }
    
    public void add(Node cur_node) {
        
        last.left.right = cur_node;
        
        cur_node.left = last.left;
        
        cur_node.right = last;
        
        last.left = cur_node; 
        
    }
    
    public int get(int key) {
        
        if (cache.containsKey(key)) {
            
            remove(cache.get(key));
            
            add(cache.get(key));
            
            return cache.get(key).val;
        }
        
        return -1;
        
        
    }
    
    public void put(int key, int value) {
        
        
        if (cache.containsKey(key)) {
            
            cache.get(key).val = value;
            
            remove(cache.get(key));
            
            add(cache.get(key));
            
        }
        
        else {
            
            Node new_node = new Node(key,value);
            
            
            if (count >= capacity) {
                
                int key_re = first.right.key;
                
                remove(first.right);
                
                cache.remove(key_re);
                
            }
                
            cache.put(key, new_node);
                
            add(new_node);
            
            count+=1;
                
            }
            
        }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
