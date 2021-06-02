public class Codec {
    
    private final Map<String, String> map = new HashMap<>();
    
    public String encode(String longUrl) {
        int hash = longUrl.hashCode();
        String strHash = Integer.toString(hash);
        map.put(strHash, longUrl);
        return strHash;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
