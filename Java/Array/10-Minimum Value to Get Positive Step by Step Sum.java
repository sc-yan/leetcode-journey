Easy Leetcode 1413
tags: Array

方法1:
题目不难。最直观的解法
方法2：
非常brilliant的解法。



```

/*
方法1
*/
class Solution {
    public int minStartValue(int[] nums) {
        int min = 1;
        while(true) {
            int sum = min;
            boolean flag = true;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if(sum < 1) {
                    min++;
                    flag = false;
                    break;
                }
            }
            if(flag) {
               return min; 
            }
        }
    }
}

/*
方法2
*/
class Solution {
    public int minStartValue(int[] nums) {
         int min = 0;
          int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, sum + nums[i]);
            sum += nums[i];
        }
        return 1 - min;
    }
}

    