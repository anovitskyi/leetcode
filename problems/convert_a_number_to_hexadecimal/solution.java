class Solution {

    private static final char[] letters = new char[] {
        '0',
        '1',
        '2',
        '3',
        '4',
        '5',
        '6',
        '7',
        '8',
        '9',
        'a',
        'b',
        'c',
        'd',
        'e',
        'f'
    };

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        while (num != 0) {
            result.append(letters[(num & 15)]); 
            num >>>= 4;
        }

        return result.reverse().toString();
    }
}