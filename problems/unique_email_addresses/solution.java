class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>(emails.length);
        
        for (String email : emails) {
            String[] parts = email.split("@");
            int indexOfPlus = parts[0].indexOf('+');
            if (indexOfPlus > 0) {
                parts[0] = parts[0].substring(0, indexOfPlus);
            }
            parts[0] = parts[0].replaceAll("\\.", "");
            set.add(parts[0] + "@" + parts[1]);
        }
        
        return set.size();
    }
}