class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(set.add(i))
                continue;
            else
                return true;
        }
        return false;
    }
}