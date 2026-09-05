class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;

        for(int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        while(r < s2.length()) {
            Set<Integer> frequencySet = new HashSet<>(map.values());
            if(frequencySet.size() == 1 && frequencySet.contains(0)) {
                return true;
            }
            char c = s2.charAt(r);
            if(map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
                r++;
            }
            else if(map.containsKey(c) && map.get(c) <= 0) {
                while(l < r && map.get(c) <= 0) {
                    char lc = s2.charAt(l);
                    if(map.containsKey(lc))
                        map.put(lc, map.get(lc) + 1);
                    l++;
                }
            }
            else {
                while(l < r) {
                    char lc = s2.charAt(l);
                    if(map.containsKey(lc)) 
                        map.put(lc, map.get(lc) + 1);
                    l++;
                }
                r++;
            }
        }
        Set<Integer> frequencySet = new HashSet<>(map.values());
        if(frequencySet.size() == 1 && frequencySet.contains(0)) {
            return true;
        }
        return false;
    }
}
