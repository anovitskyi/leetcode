class Solution {
    public int findKthLargest(int[] nums, int k) {
        // return findWithPriorityQueue(nums, k);
        // return findWithQuickSort(nums, k);
        return findWithQuickSelect(nums, k);
    }
    
    private int findWithPriorityQueue(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            queue.offer(num);
        }
        
        for (int i = 1; i < k; ++i) {
            queue.poll();
        }
        
        return queue.poll();
    }
    
    private int findWithQuickSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    
    private int findWithQuickSelect(int[] nums, int k) {
        // quickSelectRecursively(nums, 0, nums.length - 1, k - 1);
        quickSelectIteratively(nums, k - 1);
        return nums[k - 1];
    }
    
    private void quickSelectRecursively(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        
        int lastGreater = left;
        for (int i = left; i < right; ++i) {
            if (nums[i] > nums[right]) {
                int tmp = nums[i];
                nums[i] = nums[lastGreater];
                nums[lastGreater] = tmp;
                ++lastGreater;
            }
        }
        
        if (nums[right] > nums[lastGreater]) {
            int tmp = nums[right];
            nums[right] = nums[lastGreater];
            nums[lastGreater] = tmp;
        }
        
        if (lastGreater == k) {
            return;
        } else if (lastGreater < k) {
            quickSelectRecursively(nums, lastGreater + 1, right, k);
        } else {
            quickSelectRecursively(nums, left, lastGreater - 1, k);
        }
    }
    
    private void quickSelectIteratively(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int lastGreater = left;
            for (int i = left; i < right; ++i) {
                if (nums[i] > nums[right]) {
                    int tmp = nums[i];
                    nums[i] = nums[lastGreater];
                    nums[lastGreater] = tmp;
                    ++lastGreater;
                }
            }
            
            if (nums[right] > nums[lastGreater]) {
                int tmp = nums[right];
                nums[right] = nums[lastGreater];
                nums[lastGreater] = tmp;
            }
            
            if (lastGreater == k) {
                return;
            } else if (lastGreater < k) {
                left = lastGreater + 1;
            } else {
                right = lastGreater - 1;
            }
        }
    }
}