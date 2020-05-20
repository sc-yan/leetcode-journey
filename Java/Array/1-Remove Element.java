Easy Leetcode 387
1517474043
tags: String
##题目不难.
方法1:
我自己的思路。碰到不相等的，把后面的往前放。

方法2:
普通思路。从前面循环。碰到不相等的，就把它放到前面。

```

/*
方法1
*/
class Solution {
    public static int removeElement(int[] nums, int val) {
        if(nums.length ==1 && nums[0] == val) {
           return 0;
        }
        if(nums.length ==1 ) return  1;
        int i = nums.length-1, j = 0;
        for (; j < i; ) {
            if(nums[j]  == val ){
                nums[j] = nums[i];
                i--;
            }else{
                j++;
            }
        }
        return j+1;
    }
}


/*
方法2
*/

class Solution {
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
/*
方法3
正则表达式
*/
