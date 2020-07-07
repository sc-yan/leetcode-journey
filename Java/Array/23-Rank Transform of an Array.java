Easy Leetcode 1331. Rank Transform of an Array
tags: Array

方法1:
题目不难，可能会有一点不好理解。依然没有写出最巧妙地解法。
方法2：
巧妙的解法。


```

/*
方法1
*/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(s);
        for (int i = 0; i < g.length; i++) {
            int index = doExist(g[i], s);
            if(index >= 0){
                s[index] = 0;
                res++;
            }
        }
        return res;
    }
    
    public int doExist(int x, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= x){
                return i;
            }
        }
        return -1;
    }
}
/*
方法2
*/
 class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while(i < g.length && j < s.length){
            if(s[j] >= g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}