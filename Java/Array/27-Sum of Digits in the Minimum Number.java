Easy Leetcode 747. Largest Number At Least Twice of Others
tags: Array

方法1:
题目不难，都是非常常规的思路。自己解题的时候脑子不转，直接就imperative了。明明最近一直在
写functional programming
方法2：
array直接转stream



```

/*
方法1
*/
class Solution {
    public int sumOfDigits(int[] A) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++) {
            if(A[i] < min) {
                min = A[i];
            }
        }
        String s = String.valueOf(min);
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int tmp = Character.getNumericValue(c);
            sum += tmp;
        }
        return sum % 2 == 0 ? 1 : 0;
    }
}
/*
方法2
*/
public int sumOfDigits(int[] A) {
        int min = Arrays.stream(A).min().getAsInt();
        int ans = 0;
        while (min > 0) {
            ans += min % 10;
            min /= 10;
        }
        return 1 - ans % 2;
   }