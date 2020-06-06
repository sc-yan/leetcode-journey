Easy Leetcode 1287
tags: Array

方法1:
题目不难。最直观的解法 计算出现的次数
方法2：
非常巧妙的方法，更巧妙的计算次数
方法3
采用二分法。



```

/*
方法1
*/
class Solution {
    public int findSpecialInteger(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }
        int len = 1; 
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == arr[i+1]) {
                len++;
                if(len > arr.length/4) {
                    return arr[i];
                }
            }else{
                len = 1;
            }
        }
        return 1;
    }
}

/*
方法2
*/
    public int findSpecialInteger(int[] arr) {
        int n = arr.length, t = n / 4;

        for (int i = 0; i < n - t; i++) {
            if (arr[i] == arr[i + t]) {
                return arr[i];
            }
        }
        return -1;
    }