class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, 0, res, 
        new ArrayList<>(), 0);
        return res;
    }

    private void helper(int[] candidates, int target, int sum, List<List<Integer>> res, List<Integer> temp, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            sum += candidates[i];
            helper(candidates, target, sum, res, temp, i);
            temp.remove(temp.size() - 1);
            sum -= candidates[i];
        }
    }
}