Easy Leetcode 448  
1517474043
tags: Array

方法1:
题目倒是不难，难在如何不用extra space并且time complexity 是O(n).先放自己的解法。
方法2：
这个思路我比较欣赏。把数字swap到它对应的位置。
方法3:
感觉很没有必要。通过取余数来获得之前的original的数字。纯当扩展思路吧。


```

/*
方法1
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int x: nums) { map.add(x);};
        List<Integer> res = new LinkedList<>();
        for (int i = 1; i <= nums.length; i++) {
            if(map.contains(i)){
                
            }else{
                res.add(i);
            }
        }
        return res;
    }
}


/*
方法2
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
}



public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int n = nums.length;
    for (int i = 0; i < nums.length; i ++) nums[(nums[i]-1) % n] += n;
    for (int i = 0; i < nums.length; i ++) if (nums[i] <= n) res.add(i+1);
    return res;
}