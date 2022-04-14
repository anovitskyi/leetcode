class Solution {
     public int numSubarraysWithSum(int[] A, int S) {
        int left = 0, right = 0;
        int sumLo = 0, sumHi = 0;
        int ans = 0;

        for (int j = 0; j < A.length; ++j) {
            // While sumLo is too big, iLo++
            sumLo += A[j];
            while (left < j && sumLo > S)
                sumLo -= A[left++];

            // While sumHi is too big, or equal and we can move, iHi++
            sumHi += A[j];
            while (right < j && (sumHi > S || sumHi == S && A[right] == 0))
                sumHi -= A[right++];

            if (sumLo == S)
                ans += right - left + 1;
        }

        return ans;
    }
}

/*
 
      |
 [0,1,1,0,1]
          |

 goal = 2
 sum = 1
 result = 3
 
 
*/