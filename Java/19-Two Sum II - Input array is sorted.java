Easy Leetcode 167
1517474043
tags: Array

方法1:
最普通的two pointers.不过两个遍历都是从头开始。

方法2:
依然是two pointers. 我之前都喜欢用这种两头开始的方法。不过这次不知道为什么没想到，
反而选择了两遍从头遍历。大概是因为一开始想用hashset但是没想出来吧。
然后思路就中断了。

方法3:
hashset.

```

/*
方法1
*/

/*
方法2
*/

public int[] twoSum(int[] numbers, int target) {
    int l = 0, r = numbers.length - 1;
    while (numbers[l] + numbers[r] != target) {
        if (numbers[l] + numbers[r] > target) r--;
        else l++;
    }
    return new int[]{l + 1, r + 1};
}

/*
方法3
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
       Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(numbers[i])){
               return new int[]{map.get(numbers[i])+1, i+1};
            }
            map.put(target-numbers[i], i);
        }
        return new int[]{};
        
    }
}





