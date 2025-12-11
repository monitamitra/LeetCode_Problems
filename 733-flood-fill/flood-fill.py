class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:

        # if image is already desired color
        if image[sr][sc] == color:
            return image

        ogColor = image[sr][sc]
        # image[sr + 1][sc], image[sr - 1][sc], image[sr][sc + 1], image[sr][sc - 1]

        def helper(currRow, currCol):
            # out of bounds
            if currRow < 0 or currRow > len(image) - 1 or currCol < 0 or currCol > len (image[0]) - 1:
                return 
            
            # invalid cell bc doesn't match original color of source
            if image[currRow][currCol] != ogColor:
                return

            image[currRow][currCol] = color
            helper(currRow + 1, currCol)
            helper(currRow - 1, currCol)
            helper(currRow, currCol - 1)
            helper(currRow, currCol + 1)

        helper(sr, sc)
        return image