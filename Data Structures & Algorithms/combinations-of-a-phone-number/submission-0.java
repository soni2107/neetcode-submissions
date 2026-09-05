class Solution {
    Map<Character, List<Character>> map = Map.of(
        '2', List.of('a', 'b', 'c'),
        '3', List.of('d', 'e', 'f'),
        '4', List.of('g', 'h', 'i'),
        '5', List.of('j', 'k', 'l'),
        '6', List.of('m', 'n', 'o'),
        '7', List.of('p', 'q', 'r', 's'),
        '8', List.of('t', 'u', 'v'),
        '9', List.of('w', 'x', 'y', 'z')
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0)
            return result;
        generateCombinations(digits, 0, result, new StringBuilder());
        return result;
    }

    public void generateCombinations(String digits, int index, List<String> result, StringBuilder sb) {
        if(index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        List<Character> charList = map.get(digits.charAt(index));
        for(int i = 0; i < charList.size(); i++) {
            sb.append(charList.get(i));
            generateCombinations(digits, index + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
