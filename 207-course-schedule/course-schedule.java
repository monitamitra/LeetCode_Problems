class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int curr_req = prereq[1];
            adjList.get(curr_req).add(course);
            // num prereqs course has
            inDegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                // course with no prereqs 
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            // get prereqs for course
            for (int neighbor : adjList.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    // course has no more prereqs
                    q.add(neighbor);
                }
            }
        }
        return count == numCourses;
    }
}