class Solution {
    public String restoreString(String s, int[] indices) {
        char[] newTab = new char[indices.length];
        char[] tab = s.toCharArray();
        
        for (int i = 0; i < indices.length; ++i) {
            char chToMove = tab[i];
            int newIndex = indices[i];
            newTab[newIndex] = chToMove;
        }
        
        return new String(newTab);
        
    }
}