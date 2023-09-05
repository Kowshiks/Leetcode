/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Node tmp = head;
        
        HashMap<Node,Integer> prevCache = new HashMap<>();
        
        HashMap<Integer,Node> cache = new HashMap<>();
        
        int index = 0;
        
        Node second = new Node(0);
        
        Node sec_tmp = second;
        
        while (tmp != null) {
            
            sec_tmp.next = new Node(tmp.val);
            
            prevCache.put(tmp,index);
            
            cache.put(index,sec_tmp.next);
            
            tmp = tmp.next;
            
            sec_tmp = sec_tmp.next;
            
            index+=1;
            
        }
        
        sec_tmp = second.next;
        
        tmp = head;        
        
        while (sec_tmp != null) {
            
            if (tmp.random != null) {
                
                index = prevCache.get(tmp.random);
                        
                sec_tmp.random = cache.get(index);
                
            }
                
            tmp = tmp.next;
            
            sec_tmp = sec_tmp.next;
            
        } 
        return second.next; 
    }
}
