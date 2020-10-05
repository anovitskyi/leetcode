class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }
        
        int nameIndex = 0;
        int typedIndex = 0;
        
        while (nameIndex < name.length()) {
            char nameChar = name.charAt(nameIndex);
            char typedChar = typed.charAt(typedIndex);
            if (nameChar != typedChar) {
                return false;
            }
            
            int nameCounter = 0;
            int typedCounter = 0;
            while (nameIndex < name.length() && name.charAt(nameIndex) == nameChar) {
                ++nameCounter;
                ++nameIndex;
            }
            while (typedIndex < typed.length() && typed.charAt(typedIndex) == typedChar) {
                ++typedCounter;
                ++typedIndex;
            }
            
            if (nameCounter > typedCounter) {
                return false;
            }
            
            if (typedIndex >= typed.length() && nameIndex < name.length()) {
                return false;
            }
        }      
        
        return typedIndex >= typed.length();
    }
}