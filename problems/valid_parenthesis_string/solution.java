class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack1.push(i);  
            }
            if (s.charAt(i) == '*') {
                stack2.push(i);
            }
            if (s.charAt(i) == ')') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
                else {
                    if (!stack2.isEmpty()) {
                        stack2.pop();
                    }
                    else {
                        return false; // situation 1
                    }
                }
            }
        }
        while (!stack1.isEmpty()) {
            if (stack2.isEmpty()) {
                return false;  //situation 2
            }
            else {
                if (stack1.pop() > stack2.pop()) {
                    return false;
                }
            }
        }
        return true;
    }
}