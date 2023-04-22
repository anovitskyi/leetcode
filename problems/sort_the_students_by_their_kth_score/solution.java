class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        for (int i = 0; i < score.length; ++i) {
            int maxIndex = i;
            
            for (int j = i + 1; j < score.length; ++j) {
                if (score[j][k] > score[maxIndex][k]) {
                    maxIndex = j;
                }
            }

            int[] tmp = score[i];
            score[i] = score[maxIndex];
            score[maxIndex] = tmp;
        }

        return score;
    }
}