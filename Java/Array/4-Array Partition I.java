Easy Leetcode 905  acceptance rate: 70%
1517474043
tags: String
##题目不难.
方法1:
题目很简单。没啥难度。理解意思就可以了。

方法2:
unnecessarily complicated.权当多一种思路吧。
先把每个数出现的频率存一遍。再按照单数原则把他们加起来。

```

/*
方法1
*/
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return  sum;
    }
}


/*
方法2
*/

class Solution {
    public int arrayPairSum(int[] nums) {
       int[] exist = new int[20001];
		for (int i = 0; i < nums.length; i++) {
			exist[nums[i] + 10000]++;
		}
		int sum = 0;
		boolean odd = true;
		for (int i = 0; i < exist.length; i++) {
			while (exist[i] > 0) {
				if (odd) {
					sum += i - 10000;
				}
				odd = !odd;
				exist[i]--;
			}
		}
		return sum;
    }
}
/*
方法3
正则表达式
*/
