class Solution {
    
    public String decodeString(String str) {
        return decodeString(str, 0).word;
    }

    private DecodeResult decodeString(String str, int index) {
        StringBuilder builder = new StringBuilder();

        while (index < str.length() && str.charAt(index) != ']') {
            if (!Character.isDigit(str.charAt(index))) {
                builder.append(str.charAt(index));
                ++index;
                continue;
            } 

            DecodeResult result = decode(str, index);

            for (int i = 0; i < result.counter; ++i) {
                builder.append(result.word);
            }

            index = result.index + 1;
        }

        return new DecodeResult(index, 1, builder.toString());
    }

    private DecodeResult decode(String str, int index) {
        if (index >= str.length()) {
            return new DecodeResult(index, 0, "");
        }

        int counter = 0;
        while (Character.isDigit(str.charAt(index))) {
            counter *= 10;
            counter += (int) (str.charAt(index) - '0');
            ++index;
        }

        DecodeResult internalResult = decodeString(str, index + 1);
        return new DecodeResult(internalResult.index, counter, internalResult.word);
    }

    private static class DecodeResult {

        final int index;
        final int counter;
        final String word;

        DecodeResult(int index, int counter, String word) {
            this.index = index;
            this.counter = counter;
            this.word = word;
        }

    }

}