E
1517474043
tags: 

方法1:


方法2:

```
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

/*
Thoughts:
很简单的一个顺次判断。把j设定成i+1，只检查一轮。
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int x[] = new int[2];
        for (int i = 0; i<nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if ( target == nums[i] + nums[j]){
                    x[0] = i;
                    x[1] = j;
                }
            }
            
        }
        
        return x;
    }
}

/*


*/

```