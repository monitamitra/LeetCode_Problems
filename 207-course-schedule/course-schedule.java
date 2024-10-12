class Solution {
    HashMap<Integer, ArrayList<Integer>> premap = new HashMap<>();
    // make set to track all courses along curr DFS path
    HashSet<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            premap.put(i, new ArrayList<>());
        }
        for (int[] temp : prerequisites) {
            // append each prereq of course to course in map
            int course = temp[0];
            int pre = temp[1];
            premap.get(course).add(pre);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int curr_course) {
        // cycle detected, courses can't be completed 
        if (visited.contains(curr_course)) {
            return false;
        }

        // course has not prereqs, can be completed
        if (premap.get(curr_course).size() == 0) {
            return true;
        }

        visited.add(curr_course);
        for (int prereq : premap.get(curr_course)) {
            if (!dfs(prereq)) {
                return false;
            }
        }
        visited.remove(curr_course);
        premap.get(curr_course).clear();
        return true;
    }
}