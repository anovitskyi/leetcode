class OrderedStream {

    private final String[] arr;
    private int currPos = 1;
    
    public OrderedStream(int n) {
        arr = new String[n + 1];
    }
    
    public List<String> insert(int id, String value) {
        arr[id] = value;
        
        LinkedList<String> result = new LinkedList<>();
        while (currPos < arr.length && arr[currPos] != null) {
            result.add(arr[currPos++]);
        }
        return result;
    }
}