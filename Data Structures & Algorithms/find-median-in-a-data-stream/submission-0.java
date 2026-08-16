class MedianFinder {

    PriorityQueue<Integer> smallHalf = new PriorityQueue<>      (Collections.reverseOrder()); // max-heap
    PriorityQueue<Integer> largeHalf = new PriorityQueue<>(); // min-heap

    public MedianFinder() {

    }
    
    public void addNum(int num) {
        if(smallHalf.isEmpty() || num <= smallHalf.peek()){
            smallHalf.add(num);
        }else{
            largeHalf.add(num);
        }

        int temp;
        if(smallHalf.size() - largeHalf.size() > 1){
            temp = smallHalf.poll();
            largeHalf.add(temp);
        }else if(largeHalf.size() - smallHalf.size() > 1){
            temp = largeHalf.poll();
            smallHalf.add(temp);
        }
    
    }
    
    public double findMedian() {
        double median = 0.0;
        if(smallHalf.size() == largeHalf.size()){
            median = (((double) smallHalf.peek() + largeHalf.peek()) / 2);
        }else{
            if(largeHalf.size() > smallHalf.size()){
                median = largeHalf.peek();
            }else if(smallHalf.size() > largeHalf.size()){
                median = smallHalf.peek();
            }
        }

        return median;
    }
}
