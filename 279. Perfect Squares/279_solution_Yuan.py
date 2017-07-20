class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [0, 1]
        for i in range(2, n + 1):
            max = int(math.floor(math.sqrt(i)))
            minNum = -1
            for x in range(1, max + 1):
                cur = dp[i - x * x] + 1
                if minNum == -1:
                    minNum = cur
                elif minNum > cur:
                    minNum = cur
            dp.append(minNum)
        return dp[n]
