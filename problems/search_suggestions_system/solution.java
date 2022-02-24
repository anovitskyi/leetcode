class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        
        List<List<String>> result = new LinkedList<>();
        for (int i = 1; i <= searchWord.length(); ++i) {
            result.add(findSuggestions(searchWord.substring(0, i), products));
        }
        return result;
    }
    
    private List<String> findSuggestions(String word, String[] products) {
        List<String> result = new LinkedList<>();
        for (String product : products) {
            if (product.startsWith(word)) {
                result.add(product);
                if (result.size() == 3) {
                    break;
                }
            }
        }
        return result;
    }
}