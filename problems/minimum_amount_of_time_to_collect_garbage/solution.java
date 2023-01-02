class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] travelSum = new int[travel.length + 1];
        for (int i = 1; i < travelSum.length; ++i) {
            travelSum[i] = travelSum[i - 1] + travel[i - 1];
        }

        Map<Character, Truck> trucks = new HashMap<>(3);
        
        for (int i = 0; i < garbage.length; ++i) {
            String types = garbage[i];
            for (int j = 0; j < types.length(); ++j) {
                char type = types.charAt(j);
                Truck truck = trucks.computeIfAbsent(type, x -> new Truck());
                truck.time++;
                truck.travel = travelSum[i];
            }
        }

        int result = 0;

        if (trucks.containsKey('G')) {
            Truck g = trucks.get('G');
            result += g.time + g.travel;
        }

        if (trucks.containsKey('P')) {
            Truck p = trucks.get('P');
            result += p.time + p.travel;
        }

        if (trucks.containsKey('M')) {
            Truck m = trucks.get('M');
            result += m.time + m.travel;
        }

        return result;
    }

    private class Truck {
        int time = 0;
        int travel = 0;
    }
}