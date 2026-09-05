class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyCounterMap = new HashMap<>();

        //Iterate over the array and store unique integer values as key and their frequency as values
        for(int i : nums) {
            frequencyCounterMap.putIfAbsent(i, 0);
            frequencyCounterMap.put(i, frequencyCounterMap.get(i) + 1);
        }
        
        List<int[]> frequencyCounterList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : frequencyCounterMap.entrySet()) {
            frequencyCounterList.add(new int[]{entry.getValue(), entry.getKey()});
        }

        frequencyCounterList.sort((a, b) -> b[0] - a[0]);
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = frequencyCounterList.get(i)[1];
        }
        return result;
    }
}
