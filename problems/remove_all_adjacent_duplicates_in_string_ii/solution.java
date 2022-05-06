class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char currentLetter = s.charAt(i);
            
            if (stack.isEmpty() || stack.peek().letter != currentLetter) {
                stack.push(new Pair(currentLetter));
            } else if (stack.peek().quantity < k - 1) {
                ++stack.peek().quantity;
            } else { 
                stack.pop();
            }
        }
        
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            for (int i = 0; i < pair.quantity; ++i) {
                builder.append(pair.letter);
            }
        }
        return builder.reverse().toString();
    }
    
    class Pair {
        char letter;
        int quantity;
        
        Pair(char letter) {
            this.letter = letter;
            this.quantity = 1;
        }
    }
}


/*

                    |
"pbbcggttciiippooaais" k = 2


 [p:1,s:1]

*/