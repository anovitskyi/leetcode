class Solution {
    public String pushDominoes(String dominoes) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < dominoes.length(); ++i) {
            if (dominoes.charAt(i) != '.') {
                queue.offer(i);
            }
        }
        
        char[] tab = dominoes.toCharArray();
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                int index = queue.poll();
            
                if (tab[index] == 'L') {
                    if (index - 1 < 0 || tab[index - 1] != '.') {
                        continue;
                    }

                    tab[index - 1] = 'L';
                    queue.offer(index - 1);
                } else {
                    if (index + 1 >= dominoes.length() || tab[index + 1] != '.') {
                        continue;
                    }
                    
                    if (index + 2 < dominoes.length() && tab[index + 2] == 'L' && !queue.isEmpty()) {
                        queue.poll();
                        --size;
                        continue;
                    }
                    
                    tab[index + 1] = 'R';
                    queue.offer(index + 1);
                }
            }
        }
        return String.valueOf(tab);
    }
}