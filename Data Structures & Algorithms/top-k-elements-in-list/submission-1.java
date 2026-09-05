class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyCounterMap = new HashMap<>();

        //Iterate over the array and store unique integer values as key and their frequency as values
        for(int i : nums) {
            frequencyCounterMap.putIfAbsent(i, 0);
            frequencyCounterMap.put(i, frequencyCounterMap.get(i) + 1);
        }
        System.out.println(frequencyCounterMap);
        //get the list of counters from map
        Set<Integer> frequencyCounterSet = new HashSet<>(frequencyCounterMap.values());
        List<Integer> frequencyCounterList = new ArrayList<>(frequencyCounterSet);
        frequencyCounterList.sort(Comparator.reverseOrder());
        System.out.println(frequencyCounterList);
        // find k highest values
        Map<Integer, List<Integer>> reverseFrequencyMap = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : frequencyCounterMap.entrySet()) {
            reverseFrequencyMap.computeIfAbsent(entry.getValue(), b -> new ArrayList()).add(entry.getKey());
        }

        System.out.println(reverseFrequencyMap);
        // iterate over the map and get the first k values matching these frequency
        int[] resultArray = new int[k];
        int i = 0;
        for(Integer frequency : frequencyCounterList) {
            if(i >= k)
                break;
            List<Integer> elementList = reverseFrequencyMap.get(frequency);
            for(int j = 0; j < elementList.size(); j++) {
                resultArray[i] = elementList.get(j);
                i++;
            }
        }
    
        return resultArray;
    }
}
