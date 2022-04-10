class Solution {
    public int calPoints(String[] ops) {
        int result = 0;
        List<Integer> list = new ArrayList<>();
        
        for (String op : ops) {
            int elem = 0;
            if ("+".equals(op)) {
                int prev = list.get(list.size() - 1);
                int prevprev = list.get(list.size() - 2);
                elem = prevprev + prev;
                list.add(elem);
            } else if ("C".equals(op)) {
                result -= list.get(list.size() - 1);
                list.remove(list.size() - 1);
            } else if ("D".equals(op)) {
                elem = list.get(list.size() - 1) * 2;
                list.add(elem);
            } else {
                elem = Integer.parseInt(op);
                list.add(elem);
            }
            
            result += elem;
        }
    
        return result;
    }
}