class Solution {
    public boolean isPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        s = s.toLowerCase();
        while(leftPointer < rightPointer) {
            if(!isCharacterAlphanumeric(s.charAt(leftPointer)))
                leftPointer++;
            else if(!isCharacterAlphanumeric(s.charAt(rightPointer)))
                rightPointer--;
            else if(s.charAt(leftPointer) != s.charAt(rightPointer))
                return false;
            else {
                leftPointer++;
                rightPointer--;
            }
        }
        return true;
    }

    public boolean isCharacterAlphanumeric(char c) {
        return (c >= 48 && c <= 57) 
        || (c >= 65 && c <= 90)
        || (c >= 97 && c <= 122);
    }
}
