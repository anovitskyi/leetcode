class Solution {

        private int[] nums;
        private int[] origin;
        private Random random;

        public Solution(int[] nums) {
            this.origin = nums;
            this.nums = new int[nums.length];
            this.random = new Random();
            System.arraycopy(this.origin, 0, this.nums, 0, this.origin.length);
        }

        public int[] reset() {
            System.arraycopy(origin, 0, nums, 0, origin.length);
            return nums;
        }

        public int[] shuffle() {
            for (int i = 0; i < nums.length; ++i) {
                int rand = random.nextInt(nums.length);
                int tmp = nums[i];
                nums[i] = nums[rand];
                nums[rand] = tmp;
            }
            return nums;
        }
    }