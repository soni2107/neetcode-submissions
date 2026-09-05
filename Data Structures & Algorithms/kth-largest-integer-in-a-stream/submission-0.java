class KthLargest {
    PriorityQueue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        Comparator<Integer> c = (a, b) -> b - a;
        this.queue = new PriorityQueue<>(c);
        this.k = k;

        for(int num : nums) {
            queue.add(num);
        }
    }
    
    public int add(int val) {
        queue.add(val);
        PriorityQueue<Integer> copyQueue = new PriorityQueue<>(queue);
        Iterator<Integer> iterator = copyQueue.iterator();
        int i = 0;
        while(!copyQueue.isEmpty()) {
            if(i < k - 1)
                copyQueue.poll();
            else if(i == k - 1)  
                return copyQueue.poll();
            i++;
        }
        return 0;
    }
}
