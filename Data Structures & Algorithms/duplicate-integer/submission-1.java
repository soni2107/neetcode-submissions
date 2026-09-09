class Solution {
    public boolean hasDuplicate(int[] nums) {
        //Create a hashset with the values being num entries
        HashSet<Integer> valueSet = new HashSet<>();

        //Loop over the array and continue to add entries to the set
        for(int num : nums) {
            //If the insertion returns false then duplicate exists
            if(!valueSet.add(num))
                return true;
        }

        //If no duplicates found we return false;
        return false;
    }
}