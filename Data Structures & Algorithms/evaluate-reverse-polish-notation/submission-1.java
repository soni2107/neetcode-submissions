class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        List<String> operatorList = List.of("+", "-", "*", "/");
        int result = 0;
        for(int i = 0; i < tokens.length; i++) {
            String value = tokens[i];
            if(operatorList.contains(value)) {
                int valueToOperateOn2 = Integer.parseInt(stack.pop());
                int valueToOperateOn1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(performOperation(value, valueToOperateOn1, valueToOperateOn2)));
            }
            else
                stack.push(value);
        }
        return Integer.parseInt(stack.pop());
    }
    
    public int performOperation(String operator, int value1, int value2) {
        switch(operator) {
                case("+"): return value1 + value2;
                case("-"): return value1 - value2;
                case("*"): return value1 * value2;
                case("/"): return value1 / value2;
            }
        return 0;
    }
}
