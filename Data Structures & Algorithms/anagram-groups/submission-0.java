class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Create a hashmap with key being sorted string values from str and value being a list of unaltered strings which are anagrams
        Map<String, List<String>> map = new HashMap<>();

        //loop over the str values and check its existence in the map, if exists add the entry
        for(String str : strs) {
            //convert the str to char array and back to string
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);
            if(map.containsKey(temp)) {
                map.get(temp).add(str);
            }
            //else create a new entry
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(temp, list);
            }
        }
        
        
        //return the collection of values from this map
        return new ArrayList<>(map.values());
    }
}
