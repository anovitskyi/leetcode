class Solution {
    public int[] sortByBits(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        
        Integer[] tmp = new Integer[arr.length];
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int num : arr) {
            tmp[i] = arr[i];
            int counter = 0;
            while (num > 0) {
                counter += num % 2;
                num /= 2;
            }
            map.put(arr[i], counter);
            ++i;
        }
        
        Arrays.sort(tmp, (f, s) -> {
            int diff = map.get(f) - map.get(s);
            
            if (diff == 0) {
                return f - s;
            }
            
            return diff;
        });
        
        for (int j = 0; j < arr.length; ++j) {
            arr[j] = tmp[j];
        }
        
        return arr;
    }
}

// fib nth number
// fib number