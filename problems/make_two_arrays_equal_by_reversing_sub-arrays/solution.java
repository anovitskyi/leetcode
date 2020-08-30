class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(target.length);
        
        for (int i = 0; i < target.length; ++i) {
            int counter = map.getOrDefault(target[i], 0);
            map.put(target[i], counter + 1);
            sum += target[i];
        }
        
        for (int i = 0; i < arr.length; ++i) {
            Integer counter = map.get(arr[i]);
            
            if (counter == null || counter < 0) {
                return false;
            }
            
            map.put(arr[i], counter - 1);
            sum -= arr[i];
        }
    
        return sum == 0;
    }
}