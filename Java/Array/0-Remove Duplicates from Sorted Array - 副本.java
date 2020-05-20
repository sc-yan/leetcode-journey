Easy Leetcode 387
1517474043
tags: String
##题目不难.
方法1:
一开始自己试着用two poiners写，但是没写出来。
还是思路不够清晰，想复杂了。
其实特别简单。

方法2:
无敌的解法。。

```

/*
方法1
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length ==0) return 0;
        if (nums.length ==1) return 1;
        int i = 0, j= 0;
        for (; j<nums.length; ) {
            if(nums[i] == nums[j] ){
                j++;
            }else{
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
}


/*
方法2
*/

/*
方法3
正则表达式
*/
