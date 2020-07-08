Easy Leetcode 747. Largest Number At Least Twice of Others
tags: Array

方法1:
题目不难，w我直接用了treemap了。其实可以用array存两个最大值就是了`
方法2：
用的array



```

/*
方法1
*/
class Solution {
    public int dominantIndex(int[] nums) {
        if(nums.length <= 1) return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int max = map.lastKey();int index = map.get(max);
        map.pollLastEntry();
        int m2 = map.lastKey();
        if(max >= m2 * 2){
            return index;
        }
        return -1;
    }
}
/*
方法2
*/
class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1, index = -1, second = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > second)
                second = nums[i];
        }
        return second * 2 <= max ? index : -1;
    }
}


