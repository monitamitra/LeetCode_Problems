class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        # map course to prerequisites
        adj_list = {i: [] for i in range(numCourses)}
        for i in range(len(prerequisites)):
            curr = prerequisites[i]
            if curr[0] not in adj_list:
                adj_list[curr[0]] = []
            adj_list[curr[0]].append(curr[1])
        
        courseSet = set()

        def helper(curr):
            # cycle present course can't be completed
            if curr in courseSet:
                return False
            if adj_list[curr] == []:
                return True
            
            courseSet.add(curr)
            for pq in adj_list[curr]:
                if not helper(pq):
                    return False
            
            courseSet.remove(curr)
            adj_list[curr] = []
            return True

        for c in range(numCourses):
            if not helper(c):
                return False
        return True