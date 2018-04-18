
class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = set()
        nums.sort()
        for i in xrange(0, (len(nums) - 3)):
            offset = i + 1;
            remainder = target - nums[i]
            threeSumPaths = self.allThreeSumPaths(nums[offset:], remainder)
            for path in threeSumPaths:
                fourTuple = tuple([nums[i], path[0], path[1], path[2]])
                result.add(fourTuple)
                if nums[offset] == nums[-1]:
                   break
        return list(result)

    def allThreeSumPaths(self, nums, target):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = set()
        nums.sort()
        for i in xrange(0, (len(nums) - 2)):
            offset = i + 1;
            remainder = target - nums[i]
            twoSumPaths = self.allTwoSumPaths(nums[offset:], remainder)
            for path in twoSumPaths:
                result.add( (nums[i], path[0], path[1] ) )
        return list(result)

    def allTwoSumPaths(self, nums, target):
        valIdxMap = {}
        result = []
        for idx, numValue in enumerate(nums):
            valIdxMap[numValue] = idx
        for idx, numValue in enumerate(nums):
            remainder = target - numValue
            if remainder in valIdxMap and idx < valIdxMap[remainder]:
                result.append( [ nums[idx], nums[valIdxMap[remainder]] ])
        return result


def main():
    Solution().fourSum(nums=[-3,-1,0,2,4,5], target=1)

if __name__ == "__main__":
    main()