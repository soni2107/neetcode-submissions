class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(minCost(cost, 0, memo), minCost(cost, 1, memo));
    }

    public int minCost(int[] cost, int index, int[] memo) {
        if(index >= cost.length)
            return 0;
        
        if(memo[index] != -1)
            return memo[index];
        
        memo[index] = cost[index] + Math.min(minCost(cost, index + 1, memo), minCost(cost, index + 2, memo));
        return memo[index];
    }
}
