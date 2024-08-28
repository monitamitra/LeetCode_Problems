class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> tempRes = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int first = prev[0];
            int second = prev[1];
            int third = intervals[i][0];
            int fourth = intervals[i][1];

            // overlapping interval
            if (second >= third) {
                prev[1] = Math.max(second, fourth);
            } else {
                tempRes.add(prev);
                prev = intervals[i];
            }
        }

        tempRes.add(prev);

        return tempRes.toArray(new int[tempRes.size()][2]);
    }
}