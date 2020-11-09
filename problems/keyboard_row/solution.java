class Solution {
    public String[] findWords(String[] words) {
        Set<Character> first = new HashSet<>(20);
        for (char ch : "QWERTYUIOPqwertyuiop".toCharArray()) {
            first.add(ch);
        }
        Set<Character> second = new HashSet<>(18);
        for (char ch : "ASDFGHJKLasdfghjkl".toCharArray()) {
            second.add(ch);
        }
        Set<Character> third = new HashSet<>(14);
        for (char ch : "ZXCVBNMzxcvbnm".toCharArray()) {
            third.add(ch);
        }
        
        List<String> result = new LinkedList<>();
        for (String word : words) {
            boolean shouldAdd = true;
            if (first.contains(word.charAt(0))) {
                for (char ch : word.toCharArray()) {
                    if (!first.contains(ch)) {
                        shouldAdd = false;
                        break;
                    }
                }
            } else if (second.contains(word.charAt(0))) {
                for (char ch : word.toCharArray()) {
                    if (!second.contains(ch)) {
                        shouldAdd = false;
                        break;
                    }
                }
            } else if (third.contains(word.charAt(0))) {
                for (char ch : word.toCharArray()) {
                    if (!third.contains(ch)) {
                        shouldAdd = false;
                        break;
                    }
                }
            }
            
            if (shouldAdd) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}