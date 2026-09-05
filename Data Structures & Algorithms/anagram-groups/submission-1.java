class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Create a HashMap with key as string and value as list of string
        Map<String, List<String>> resultMap = new HashMap<>();
        
        //go through the array, sort the anagrams and if they do not exist in the map then add them as key
        //else add them to the corresponding existing list
        for(String anagram : strs) {
            String sortedString = sortString(anagram);
            if(resultMap.containsKey(sortedString)) {
                resultMap.get(sortedString).add(anagram);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(anagram);
                resultMap.put(sortedString, list);
            }
        }
        
        //return the result
        return new ArrayList<>(resultMap.values());
    }

    private String sortString(String string) {
        char[] array = string.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
