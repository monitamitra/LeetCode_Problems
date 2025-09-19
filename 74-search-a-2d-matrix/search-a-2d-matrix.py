class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        for row in matrix:
            if target <= row[len(row) - 1]:
                # do binary search on row
                
                l, r = 0, len(row) - 1
                while l <= r:
                    m = l + ((r - l) // 2)
                    if row[m] < target:
                        l = m + 1
                    elif row[m] > target:
                        r = m - 1
                    else:
                        return True

        return False