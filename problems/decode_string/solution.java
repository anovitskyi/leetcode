class Solution {
    public String decodeString(String s) {
        return decode(s, 0, s.length());
    }
    
    private String decode(String s, int start, int end) {
        StringBuilder b = new StringBuilder();
        
        for (int i = start; i < end; ++i) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                b.append(ch);
            } else if (ch >= '1' && ch <= '9') {
                int counter = 0;
                do {
                    counter = counter * 10 + (ch - '0');
                    ch = s.charAt(++i);
                } while (ch >= '0' && ch <= '9');
                
                int st = i + 1;
                int brackets = 0;
                while (++i < end) {
                    ch = s.charAt(i);
                    if (ch == '[') {
                        ++brackets;
                    } else if (ch == ']') {
                        if (brackets == 0) {
                            break;
                        } else {
                            --brackets;
                        }
                    }
                }
                
                
                String copy = decode(s, st, i);
                for (int j = 0; j < counter; ++j) {
                    b.append(copy);
                }
            }
        }
        
        return b.toString();
    }
}