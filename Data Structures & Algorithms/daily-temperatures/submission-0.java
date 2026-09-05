class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            int counter = 0;
            int warmerTemperature = Integer.MIN_VALUE;
            for(int j = i + 1; j < temperatures.length; j++) {
                counter++;
                if(temperatures[i] < temperatures[j]) {
                    warmerTemperature = temperatures[j];
                    break;
                }
            }
            if(warmerTemperature != Integer.MIN_VALUE)
                result[i] = counter;
            else
                result[i] = 0;
        }

        return result;
    }
}
