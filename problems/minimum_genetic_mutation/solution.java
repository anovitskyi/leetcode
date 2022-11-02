class Solution {
    
    private static final char[] LETTERS = new char[] { 'A', 'C', 'G', 'T' };
    
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        
        Set<String> bankSet = new HashSet<>();
        for (String b : bank) {
            bankSet.add(b);
        }
        
        Set<String> visited = new HashSet<>();
        
        int result = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String top = queue.poll();
                
                if (visited.contains(top)) {
                    continue;
                }
                visited.add(top);
                
                if (top.equals(end)) {
                    return result;
                }
                
                char[] tab = top.toCharArray();
                for (int i = 0; i < tab.length; ++i) {
                    char copy = tab[i];
                    for (char letter : LETTERS) {
                        tab[i] = letter;
                        String tmp = new String(tab);
                        if (bankSet.contains(tmp)) {
                            queue.offer(tmp);   
                        }
                    }
                    tab[i] = copy;
                }
            }
            
            ++result;
        }
        
        return -1;
    }
}