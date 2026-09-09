class Solution {
    public boolean isAnagram(String s, String t) {
        //Initial check for length match of s and t
        if(s.length() != t.length())
            return false;
        
        //Create an array of 26 length corresponding to 26 letters in the alphabet
        int[] alpArray = new int[26];

        //Loop over the string characters and increase value of array index with s char and reduce it with t char
        for(int i = 0; i < s.length(); i++) {
            int sIndex = s.charAt(i) - 'a';
            int tIndex = t.charAt(i) - 'a';

            alpArray[sIndex] += 1;
            alpArray[tIndex] -= 1;
        }

        //Check the values in the array and if all are 0 then anagram else it is not
        for(int val : alpArray) {
            if(val != 0)
                return false;
        }
        
        return true;
    }
}
