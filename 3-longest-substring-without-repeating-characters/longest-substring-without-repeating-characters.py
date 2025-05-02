class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        last_seen = [-1] * 128  # Fixed size for ASCII (faster than dictionary)
        max_len = 0
        start = 0

        for i, char in enumerate(s):
            ascii_index = ord(char)
            if last_seen[ascii_index] >= start:
                start = last_seen[ascii_index] + 1
            last_seen[ascii_index] = i
            max_len = max(max_len, i - start + 1)

        return max_len
