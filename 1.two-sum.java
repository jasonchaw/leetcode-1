/*
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (37.57%)
 * Total Accepted:    830.8K
 * Total Submissions: 2.2M
 * Testcase Example:  '[3,2,4]\n6'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++)
        {
            maps.put(numbers[i], i);
        }
        int index1 = -1;
        int index2 = -1;
        for(int i = 0; i < numbers.length; i++)
        {
            int diff = target - numbers[i];
            if(maps.containsKey(diff))
            {
                index1 = i;
                index2 = maps.get(diff);
                if(index1 != index2)
                    break;
            }
        }
        
        return new int[] {index1, index2};	    
    }
}
