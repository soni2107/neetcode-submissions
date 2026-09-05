class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int counter = 0;
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            set.add(c);
            map.put(c, map.get(c) - 1);
            counter++;
            if(map.get(c) == 0) {
                set.remove(c);
                if(set.isEmpty()) {
                    result.add(counter);
                    counter = 0;
                }
            }
        }

        return result;
    }
}
