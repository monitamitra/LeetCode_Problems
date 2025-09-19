class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        # len(piles) <= h bc koko has to eat all of the piles 
        # and can only eat 1 pile per hour 

        # try every value from 1...max(piles[i]) to look for min k 
        # value in which koko can eat all bananas within h hours

        l, r = 1, max(piles)
        res = r

        while l <= r:
            k = (l + r) // 2
            hrs = 0
            # check to see if k value is enough for koko to eat all bananas
            for p in piles:
                hrs += math.ceil(p / k)
            
            # update min k eating speed 
            if hrs <= h:
                res = min(res, k)
                # look for even more smaller k (search left)
                r = k - 1
            else:
                # look for bigger k, rate was too small (search right)
                l = k + 1
        
        return res
