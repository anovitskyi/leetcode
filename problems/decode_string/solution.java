class Solution {
    public String decodeString(String s) {
        
        int lastIndex = s.lastIndexOf('[');
        if(lastIndex<0) return s;
        int temp=lastIndex-1;
        String repeatString="";
        while(temp>=0){
            if(Character.isDigit(s.charAt(temp))){
                temp--;
            }
            else break;
        }
        
        int repeatNum=Integer.parseInt(s.substring(temp+1,lastIndex));
        
        String rpStr=s.substring(lastIndex+1, s.indexOf(']',lastIndex));
        rpStr=rpStr.repeat(repeatNum);
        s=s.replace((s.substring(temp+1,s.indexOf(']',temp+1)+1)),rpStr);
        return decodeString(s);      
        
    }
}