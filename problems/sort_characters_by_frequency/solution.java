class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        List<Character> chars = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            chars.add(ch);
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }

        Collections.sort(chars, ((a, b) -> {
            int counterDiff = counter.get(b) - counter.get(a);

            if (counterDiff != 0) {
                return counterDiff;
            }

            return b - a;
        }));
        StringBuilder b = new StringBuilder();
        for (char ch : chars) {
            b.append(ch);
        }
        return b.toString();
    }
}


/**

    loveleetcode

    e: 4
    l: 2
    o: 2
    v: 1
    t: 1
    c: 1
    d: 1

    eeee
 */