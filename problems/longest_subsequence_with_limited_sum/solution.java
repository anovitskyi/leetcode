class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < answer.length; ++i) {
            answer[i] = findSubsequence(nums, queries[i]);
        }

        return answer;
    }

    private int findSubsequence(int[] nums, int limit) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (right - left) / 2 + left;

            if (nums[middle] <= limit) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }
}

/*

    [4,5,2,1]
    [1,2,4,5]
         |    
    [1,2,3,7,13]

 */