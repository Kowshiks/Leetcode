class MedianFinder {
    
    private PriorityQueue<Integer> heap_small;
    
    private PriorityQueue<Integer> heap_big;
    
    private int left;
    
    private int right;

    public MedianFinder() {
        
        heap_small = new PriorityQueue<Integer>(Comparator.reverseOrder());
        
        heap_big = new PriorityQueue<Integer>();
        
    }
    
    public void addNum(int num) {
        
        
        if (heap_small.isEmpty()) {
            
            heap_small.offer(num);
            
        }
        
        else if (heap_big.isEmpty()) {
            
            left = heap_small.peek();
            
            if (left <= num) {
                
                heap_big.offer(num);
                
            }
            
            else {
                
                heap_small.poll();
                heap_small.offer(num);
                heap_big.offer(left) ;
                
            }
            
        }
            
        else {
            
            left = heap_small.poll();
            
            right = heap_big.poll();
            
            
            if (heap_small.size() == heap_big.size()) {
                
                if ((num >= left && num < right) ||  (num < left)){
                    
                    heap_small.offer(left);
                    
                    heap_small.offer(num);
                    
                    heap_big.offer(right);
                    
                }
                
                else {
                    
                    heap_small.offer(left);
                    
                    heap_big.offer(num);
                    
                    heap_big.offer(right);
                    
                }
                
            }
            
            else if (heap_small.size() > heap_big.size()) {
                
                if (num >= left) {
                    
                    
                    heap_small.offer(left);
                    
                    heap_big.offer(num);
                    
                    heap_big.offer(right);
                    
                }
                
                else {
                    
                    heap_small.offer(num);
                    
                    heap_big.offer(left);
                    
                    heap_big.offer(right);
                      
                }  
            }
            
            else if (heap_small.size() < heap_big.size()) {
                
                if (num <= right) {
                    
                    
                    heap_small.offer(left);
                    
                    heap_small.offer(num);
                    
                    heap_big.offer(right);
                    
                }
                
                else {
                    
                    heap_big.offer(num);
                    
                    heap_small.offer(left);
                    
                    heap_small.offer(right);
                       
                }   
            }   
        }
        
    }
    
    public double findMedian() {
        
        if (heap_small.size() == heap_big.size()) {
            
            left = heap_small.peek();
            
            right = heap_big.peek();
            
            return (left+right) / (double) 2;
            
        }
        
        else if (heap_small.size() > heap_big.size()) {
            
            return heap_small.peek();
        }
        
        else {
        
            return heap_big.peek();
            
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
