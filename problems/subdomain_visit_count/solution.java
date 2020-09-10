class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String domain : cpdomains) {
            String[] pair = domain.split(" ");
            Integer counter = Integer.parseInt(pair[0]);
            String[] domains = pair[1].split("\\.");
            
            String prev = "";
            for (int i = domains.length - 1; i >= 0; --i) {
                String tmp = domains[i] + prev;
                Integer c = map.getOrDefault(tmp, 0) + counter;
                
                map.put(tmp, c);
                prev = "." + tmp;
            }
        }
        
        List<String> result = new LinkedList<>();
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        
        return result;
    }
}