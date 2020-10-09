class Solution {
    public String reformatDate(String date) {
        Map<String, String> months = new HashMap<>(12);
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        
        String[] data = date.split(" ");
        String year = data[2];
        String month = months.get(data[1]);
        String day = data[0].substring(0, data[0].length() - 2);
        if (day.length() == 1) {
            day = "0" + day;
        }
        
        return String.format("%s-%s-%s", year, month, day);
    }
}