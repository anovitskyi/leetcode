class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] arr1 = convertToArray(word1);
        int[] arr2 = convertToArray(word2);
		
        for (int i = 0; i < 26; ++i) {
            if (arr1[i] != arr2[i] && (arr1[i] == 0 || arr2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] convertToArray(String word) {
        int[] arr = new int[26];
        
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            ++arr[index];
        }

        return arr;
    }

}