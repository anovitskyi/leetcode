class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (stack.isEmpty() || Math.abs(s.charAt(i) - stack.peek()) != 32) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }

        char[] tab = new char[stack.size()];
        for (int i = tab.length - 1; i >= 0; --i) {
            tab[i] = stack.pop();
        }
        return new String(tab);
    }
}