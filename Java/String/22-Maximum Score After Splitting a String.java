Easy Leetcode 1422

Maximum Score After Splitting a String

tags: String

方法1:
自己的方法， 纯intuitive，就是遍历两遍。

方法2:
非常聪明的方法，解法如下。
Logic behind this -
Result = Max of (ZerosOnLeft + OnesOnRight)
= Max of (ZerosOnLeft + (TotalOnes - OnesOnLeft))
= Max of (ZerosOnLeft - OnesOnLeft) + TotalOnes (as TotalOnes is constant)



```

/*
方法1
*/

    public int maxScore(String s) {
        int one = 0;
        for (int i = 0; i < s.length(); i++)  if(s.charAt(i) == '1')  one++;
        int left = 0;int max = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == '1') {
                one--;
            }else{
                left++;
            }
            max = Math.max(max, left + one);
        }
        return max;
    }

/*
方法2
*/

public int maxScore(String s) {
    int zeros = 0, ones = 0, max = Integer.MIN_VALUE;
    for(int i=0;i<s.length();i++) {
        if(s.charAt(i) == '0') zeros++; else ones++;
        if(i != s.length()-1) max = Math.max(zeros - ones, max);
    }
    return max + ones;
}
