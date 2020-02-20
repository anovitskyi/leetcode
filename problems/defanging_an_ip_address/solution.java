class Solution {
    // public String defangIPaddr(String address) {
    //     return address.replace(".", "[.]");   
    // }
    
     public String defangIPaddr(String address) {
         char[] tab = address.toCharArray();
         StringBuilder b = new StringBuilder();
         
         for (int i = 0; i < tab.length; ++i) {
             if (tab[i] == '.') {
                 b.append("[.]");
             } else {
                 b.append(tab[i]);
             }    
         }
         
         return b.toString();
    }
}