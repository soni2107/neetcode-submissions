class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Integer, Character> map = new HashMap<>();
        int p1 = 0;
        int p2 = 0;
        int maxLength = 0;
        while(p2 < s.length()) {
            char c = s.charAt(p2);
            if(!map.containsValue(c)) {
                map.put(p2++, c);
                maxLength = Math.max(maxLength, map.size());
            }
            else {
                while(p1 < p2 && map.containsValue(c)) {
                    map.remove(p1++);
                }
            }
        }
        return maxLength;
    }
}
