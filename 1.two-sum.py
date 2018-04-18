class Solution(object):

    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        idxMap = dict()
        for idx, numValue in enumerate(nums):
            idxMap[numValue] = idx
        for idx, numValue in enumerate(nums):
            remainder = (target - numValue)
            if remainder in idxMap:
                if idxMap[remainder] != idx:
                    return idx, idxMap[remainder]
        return Null

