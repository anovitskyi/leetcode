class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new LinkedList<>();
        
        int size = 12 * 60;
        for (int i = 0; i < size; ++i) {
            int hour = i / 60;
            int minute = i % 60;
            
            int counter = 0;
            while (hour > 0) {
                if (hour % 2 == 1) {
                    ++counter;
                }
                
                hour /= 2;
            }
            
            while (minute > 0) {
                if (minute % 2 == 1) {
                    ++counter;
                    if (counter > num) {
                        break;
                    }
                }
                
                minute /= 2;
            }
            
            if (counter == num) {
                result.add(
                    String.format("%d:%02d", i / 60, i % 60)
                );
            }
        }
        
        return result;
    }
}