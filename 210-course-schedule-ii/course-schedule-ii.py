class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        res = []

        # build graph to default as list for missing keys 
        # course = node in graph, edge from prereq to course 
        # making adjcency list 
        graph = defaultdict(list)
        for course, prereq in prerequisites:
            graph[prereq].append(course)
        
        # calculate incoming edges of a node 
        # => count number of prereqs for each course
        in_degree = [0] * numCourses
        for course, prereq in prerequisites:
            in_degree[course] += 1
        
        # courses with no prereqs can be taken first 
        queue = deque()
        for i in range(numCourses):
            if in_degree[i] == 0:
                queue.append(i)
        
        # pop course off queue and then check graph for prereqs until 0 remaining
        while queue:
            node = queue.popleft()
            res.append(node)
            for neighbor in graph[node]:
                in_degree[neighbor] -= 1
                if in_degree[neighbor] == 0:
                    queue.append(neighbor)
        
        if len(res) < numCourses:
            return []
        return res


        return res