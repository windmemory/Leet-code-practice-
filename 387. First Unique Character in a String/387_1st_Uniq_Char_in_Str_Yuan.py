class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        hash = {}
        for c in s:
            if c not in hash:
                hash[c] = 0
            else:
                hash[c] += 1
        for i in range(0, len(s)):
            if (hash[s[i]] == 0):
                return i
        return -1
