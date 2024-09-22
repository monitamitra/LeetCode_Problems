class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int res = 0;
        int cityA = 0;
        int cityB = 0;
        Arrays.sort(costs, (a, b) -> Integer.compare(Math.abs(a[0] - a[1]), Math.abs(b[0] - b[1])));

        for (int i = costs.length - 1; i >= 0; i--) {
            int costA = costs[i][0];
            int costB = costs[i][1];

            if (cityA == costs.length / 2) {
                res += costB;
            } else if (cityB == costs.length / 2) {
                res += costA;
            } else {
                if (costA < costB) {
                    res += costA;
                    cityA++;
                } else if (costA > costB) {
                    res += costB;
                    cityB++;
                } else {
                    res += costA;
                }
            }
        }
        return res;
    }
}