class Solution {
    public boolean isPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;
        s = s.toLowerCase();
        while(leftPointer < rightPointer) {
            while(leftPointer < s.length() && !isCharacterAlphanumeric(s.charAt(leftPointer)))
                leftPointer++;
            while(rightPointer >= 0 && !isCharacterAlphanumeric(s.charAt(rightPointer)))
                rightPointer--;
            
            if(leftPointer < s.length() && rightPointer >= 0 && s.charAt(leftPointer) != s.charAt(rightPointer))
                return false;
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    public boolean isCharacterAlphanumeric(char c) {
        return (c >= 48 && c <= 57) 
        || (c >= 65 && c <= 90)
        || (c >= 97 && c <= 122);
    }
}
