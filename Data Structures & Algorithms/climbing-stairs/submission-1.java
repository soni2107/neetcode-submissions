class Solution {
    Map<Integer, Integer> map = new HashMap<>(Map.of(
        1, 1,
        2, 2
    ));
    public int climbStairs(int n) {
        if(map.containsKey(n))
            return map.get(n);
        map.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return map.get(n);
    }
}
