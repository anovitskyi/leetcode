class Solution {
     public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        boolean flag = false;
        int count = 0;
        for(String word : words){
            if(!map.containsKey(word)){
                map.put(word, 1);
            }
            else{
                map.put(word, map.get(word)+1);
            }
        }
        List<String> l = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            l.add(entry.getKey());
        }
        for(String s : l){
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            String t = sb.reverse().toString();
            if(s.equals(t)){
                count += map.get(s)/2;
                if(map.get(s)%2 == 1){
                    flag = true;
                }
            }
            else{
                if(map.get(t) != null){
                    count += Math.min(map.get(s), map.get(t));
                    map.remove(s);
                }
            }
        }
        count = count * 4;
        if(flag){
            count += 2;
        }
        return count;
    }
}