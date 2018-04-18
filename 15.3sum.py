
class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = set()
        nums.sort()
        for i in xrange(0, (len(nums) - 2)):
            offset = i + 1;
            twoSumPaths = self.allTwoSumPaths(nums[offset:], -nums[i])
            for path in twoSumPaths:
                result.add( (nums[i], path[0], path[1] ) )
            if nums[offset] == nums[-1]:
                break
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
    Solution().threeSum(nums=[-1,0,1,2,-1,-4])

if __name__ == "__main__":
    main()