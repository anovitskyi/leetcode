class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        
        for (int i = 0; i < arr.length;) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            
            int[] piece = map.get(arr[i]);
            for (int j = 0; j < piece.length; ++j, ++i) {
                if (arr[i] != piece[j]) {
                    return false;
                }
            }
        }
        
        
        return true;
    }
}

// store pieces in a hashmap, where key will be first element of pieces array and value will be this array
// iterate through arr. Find pieces array by its first element. If no found -> return false. If found iterate through pieces array and check elements one by one