class Solution {
    public Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int result = change(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int change(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        if(map.containsKey(amount))
            return map.get(amount);
        
        int res = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(amount >= coin) {
                int result = change(coins, amount - coin);
                if(result != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + result);
                }
            }
        }
        map.put(amount, res);
        return res;
    }
}
