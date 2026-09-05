class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        int l = 0;
        int r = 0;
        int result = 0;
        int maxFrequency = 0;

        for(; r < s.length(); r++) {
            char c = s.charAt(r);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, frequencyMap.get(c));

            //Scenario when window length - maxFrequency is more than k
            while((r - l + 1) - maxFrequency > k) {
                char lc = s.charAt(l);
                frequencyMap.put(lc, frequencyMap.get(lc) - 1);
                l++;
            }
            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
