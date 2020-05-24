class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String tab[] = email.split("@");
            tab[0] = tab[0].replaceAll("\\+.*|\\.", "");
            
            set.add(tab[0] + "@" + tab[1]);
        
        }
        
        return set.size();
    }
}