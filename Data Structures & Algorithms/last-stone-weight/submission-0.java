class Solution {
    public int lastStoneWeight(int[] stones) {
        Comparator<Integer> comparator = (a, b) -> b - a;
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        for(int stone : stones) {
            queue.add(stone);
        }

        while(queue.size() > 1) {
            int y = queue.poll();
            int x = queue.poll();
            int remainder = (y >= x) ? y - x: x - y;
            if(remainder != 0)
                queue.add(remainder);
        }

        if(queue.size() == 1)
            return queue.poll();
        else
            return 0;
    }
}
