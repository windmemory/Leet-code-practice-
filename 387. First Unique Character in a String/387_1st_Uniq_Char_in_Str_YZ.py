class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return -1
        mydic = {}
        
        for ind, ch in enumerate(s):
            if ch not in mydic:
                mydic[ch] = [1,ind]
            else:
                mydic[ch][0] += 1
        newlist = mydic.values()
        print mydic
        ans= []
        for i in newlist:
            if i[0] == 1:
                ans.append(i[1])
        return min(ans) if ans else -1
        
            
        
