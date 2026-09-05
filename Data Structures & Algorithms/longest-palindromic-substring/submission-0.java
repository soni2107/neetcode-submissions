class Solution {
    public String longestPalindrome(String s) {
        String palindrome = new String();
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                StringBuilder sb = new StringBuilder(s.subSequence(i, j));
                if(sb.toString().equals(sb.reverse().toString()) && palindrome.length() < sb.length()) {
                    palindrome = sb.toString();
                }                
            }
        }

        return palindrome;
    }
}
