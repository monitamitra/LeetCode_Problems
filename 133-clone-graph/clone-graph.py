"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None

        oldToNew = {}

        def dfs(curr: Optional["Node"]):
            if curr in oldToNew:
                return oldToNew[curr]
            
            new_node = Node(curr.val)
            oldToNew[curr] = new_node
            
            for neighbor in curr.neighbors:
                temp_res = dfs(neighbor)
                new_node.neighbors.append(temp_res)
            
            return new_node
        
        return dfs(node)
            