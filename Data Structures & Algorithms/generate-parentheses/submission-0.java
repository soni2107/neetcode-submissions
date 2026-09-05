class Solution {
    public List<String> generateParenthesis(int n) {
         List<String> result = new ArrayList<>();
         generate(n, 0, 0, result, new StringBuilder());
         return result;
    }

    public void generate(int n, int open, int close, List<String> result, StringBuilder sb) {
        if(open == n && close == n) {
            result.add(sb.toString());
            return;
        }

        if(open < n) {
            sb.append("(");
            generate(n, open + 1, close, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open) {
            sb.append(")");
            generate(n, open, close + 1, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
