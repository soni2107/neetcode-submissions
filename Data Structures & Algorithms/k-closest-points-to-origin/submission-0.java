class CoordinateValues {
    int[] coordinates;
    double distanceToOrigin;

    public CoordinateValues(int[] coordinates) {
        this.coordinates = coordinates;
        double xCoordinateDiffSquared = Math.pow((coordinates[0] - 0), 2);
        double yCoordinateDiffSquared = Math.pow((coordinates[1] - 0), 2);
        this.distanceToOrigin = Math.sqrt(xCoordinateDiffSquared + yCoordinateDiffSquared);
    }
}

class Solution {
    Comparator<CoordinateValues> compare = (a, b) -> Double.compare(b.distanceToOrigin, a.distanceToOrigin);
    PriorityQueue<CoordinateValues> queue = new PriorityQueue<>(compare);
    
    public int[][] kClosest(int[][] points, int k) {
        for(int[] point : points) {
            CoordinateValues coordinate = new CoordinateValues(point);
            queue.add(coordinate);
            if(queue.size() > k)
                queue.poll();
        }
        int[][] result = new int[queue.size()][2];
        Iterator<CoordinateValues> iterator = queue.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            int[] coordinates = iterator.next().coordinates;
            result[i][0] = coordinates[0];
            result[i][1] = coordinates[1];
            i++;
        }

        return result;
    }
}
