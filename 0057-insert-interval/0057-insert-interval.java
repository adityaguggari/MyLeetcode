class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int[] interval : intervals) {
            if(interval[1] < newInterval[0]) {
                result.add(interval);
            }
            else if(newInterval[1] < interval[0]) {
                result.add(newInterval);
                newInterval = interval;
            }
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
            
            if(newInterval!=null) {
                result.add(newInterval);
            }
        
        return result.toArray(new int[result.size()][]);
    }
}

//https://www.youtube.com/watch?v=NWM4e4yda0w&t=545s