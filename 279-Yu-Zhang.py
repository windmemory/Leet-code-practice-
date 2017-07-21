class Solution(object):
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 1:
            return 0
        
        # if the number n can n % 4 =0, that means the squares must contain 4
        while n % 4 == 0:
            n = n / 4 
        
        
    # if the number n is n% 8 == 7, that means there should be 4 squares numbers. such as, 7, 23    
        if n % 8 == 7:
            return 4
        
        for i in range(int(math.floor(math.sqrt(n))), 0, -1):
            j = int(math.sqrt(n -  i * i))
            if i * i + j * j == n:
                return 1 if not(j) else 2
        
        return 3
