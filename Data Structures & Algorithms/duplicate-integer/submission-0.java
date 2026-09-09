class Solution {
    public boolean hasDuplicate(int[] nums) {
        //Create a hashmap with key as num entries and value as its frequency
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        //Loop over the array and put unavailable keys in the hashmap
        for(int num : nums) {
            //If a key is found in the hashmap then we return true as duplicate exists
            if(frequencyMap.containsKey(num))
                return true;
            
            frequencyMap.put(num, 1);
        }

        //If no duplicates found we return false;
        return false;
    }
}