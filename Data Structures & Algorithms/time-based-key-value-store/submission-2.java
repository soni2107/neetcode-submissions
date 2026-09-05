class TimeMap {

    private HashMap<String, HashMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            map.get(key).put(timestamp, value);
        }
        else {
            HashMap<Integer, String> valueTimestampMap = new HashMap<>();
            valueTimestampMap.put(timestamp, value);
            map.put(key, valueTimestampMap);
        }
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            HashMap<Integer, String> valueTimestampMap = map.get(key);
            if(valueTimestampMap.containsKey(timestamp))
                return valueTimestampMap.get(timestamp);
            else {
                List<Integer> keyList = new ArrayList<>(valueTimestampMap.keySet());
                keyList.sort(Integer::compare);
                int nextMaxTimestamp = Integer.MIN_VALUE;
                for(Integer k : keyList) {
                    if(k < timestamp)
                        nextMaxTimestamp = k;
                    else
                        break;
                }
                return valueTimestampMap.getOrDefault(nextMaxTimestamp, "");
            }
            
        }
        return "";
    }
}
