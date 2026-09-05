class Solution {

    public String encode(List<String> strs) {
        StringBuilder combinedStringBuilder = new StringBuilder();
        for(String s : strs)
            combinedStringBuilder.append("~").append(s);
        return combinedStringBuilder.toString();
    }

    public List<String> decode(String str) {
        if(str.isEmpty())
            return new ArrayList<>();
        System.out.println(str);
        String[] array = str.substring(1).split("~", -1);
        return List.of(array);
    }
}
