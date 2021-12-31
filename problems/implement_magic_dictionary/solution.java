class MagicDictionary {

    private String[] dictionary;
    
    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }
    
    public boolean search(String searchWord) {
        for (String word : dictionary) {
            if (searchWord.length() != word.length()) {
                continue;
            }
            
            int diff = 0;
            for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    if (diff == 1) {
                        ++diff;
                        break;
                    }
                    ++diff;
                }
            }
            if (diff == 1) {
                return true;
            }
        }
        
        return false;
    }
}
