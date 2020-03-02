class Solution {
    public int repeatedNTimes(int[] A) {
         for(int i=1; i<4; i++)
            for(int j=0; j<A.length-i; j++)
                if(A[j]==A[j+i])
                    return A[j];
        return -1;
        
        
    }
}