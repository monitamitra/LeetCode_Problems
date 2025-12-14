class SnapshotArray:

    def __init__(self, length: int):
        self.array = [[(0, 0)] for _ in range(length)]
        self.snap_id = 0
        
    def set(self, index: int, val: int) -> None:
        curr_list = self.array[index]
        
        # already modified index in current snapshot
        if curr_list[-1][1] == self.snap_id:
            curr_list[-1] = (val, self.snap_id)
        else:
            self.array[index].append((val, self.snap_id))

    def snap(self) -> int:
        self.snap_id += 1
        return self.snap_id - 1

    def get(self, index: int, snap_id: int) -> int:
        curr_list = self.array[index]
        l, r = 0, len(curr_list) - 1

        while l <= r:
            m = (l + r) // 2
            curr_val = curr_list[m]
            
            if curr_val[1] == snap_id:
                return curr_val[0]
            
            if curr_val[1] < snap_id:
                l = m + 1
            else:
                r = m - 1
        
        # If we didn't find an exact match, 'r' is now pointing 
        # to the closest snapshot that happened BEFORE (or at) our target.
        # Since snap_id=0 is always guaranteed to exist, 'r' will never be -1.
        return curr_list[r][0]



# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)