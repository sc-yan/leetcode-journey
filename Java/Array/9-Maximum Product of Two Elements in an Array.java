Easy Leetcode 1464
tags: Array

方法1:
题目不难。依旧是自己的思路，没有用任何数据结构。单纯array操作的话，效率最快
方法2：
priorityqueue。
方法3：
TreeMap


```

/*
方法1
*/
//import java.util.stream.IntStream;
    public int maxProduct(int[] nums) {
        int max, max2nd; 
        max = max2nd = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= max) {
                max2nd = max;
                max = num;
            } else if (num >= max2nd) {
                max2nd = num;
            }
        }
        return (max -1 ) * (max2nd -1);
    }


/*
方法2
*/
 public int maxProduct(int[] nums) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: nums) max.offer(num);
        // pop up the max number to get 2nd max
        return (max.poll() -1) * (max.poll() -1);
    }

/*
方法3
*/
public int maxProduct(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // save how many times the number appears in the array. you will see why right now 
        for (int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        if(map.get(map.lastKey()) >= 2) {
            return (map.lastKey() -1) * (map.lastKey() -1);
        }else{
            // pop up the max number to get 2nd max
            int max = map.lastKey() -1;
            map.remove(map.lastKey());
            return (max * (map.lastKey() -1));
        }
    }

    