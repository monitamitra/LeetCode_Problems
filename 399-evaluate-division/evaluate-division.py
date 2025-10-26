class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        # a -> list of [b, a/b]
        adj = collections.defaultdict(list)

        for i, eq in enumerate(equations):
            a, b = eq
            adj[a].append([b, values[i]])
            adj[b].append([a, 1 / values[i]])
        
        def bfs(src, target):
            # a -> b = a / b
            if src not in adj or target not in adj:
                return -1
            
            q, visit = deque(), set()
            q.append([src, 1])
            visit.add(src)
            while q:
                node, weight = q.popleft()
                if node == target:
                    return weight

                for n, w in adj[node]:
                    if n not in visit:
                        q.append([n, weight * w])
                        visit.add(n) 
            return -1
        
        return [bfs(q[0], q[1]) for q in queries]
        
            