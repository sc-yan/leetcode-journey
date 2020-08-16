Easy Leetcode 747. Largest Number At Least Twice of Others
tags: Array

方法1:
题目不难，都是非常常规的思路。巧妙的是，如何在一遍循环中就计算出次数。 1 ... n 的和
方法2：
巧妙的只用一遍循环
方法3：
这个方法挺有意思。先排序，然后算count



```

/*
方法1
*/
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int x:map.values()){
            res += ss(x);
        }
        return res;
    }

    public int ss(int x) {
        int n = x-1;
        return n*(1 + n) /2;
    }
}
/*
方法2
*/
   public int numIdenticalPairs(int[] A) {
        int res = 0, count[] = new int[101];
        for (int a: A) {
            res += count[a]++;
        }
        return res;
    }
class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int count = 0;
        for (int num : nums) {
            count += map.getOrDefault(num, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}

-------------------
class Solution {
    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i])
                count += j - i;
            else i = j;
        }
        return count;
    }
}