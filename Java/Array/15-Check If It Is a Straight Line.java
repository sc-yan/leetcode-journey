Easy Leetcode 1232
tags: Array

方法1:
题目不难。直接算斜率就可以。但是我是按照除法算的，导致需要考虑小数和0的情况
方法2：
把除法转变为乘法，更简单了


```

/*
方法1
*/
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] x = coordinates[0];
        int[] y = coordinates[1];
        float k = y[0] - x[0] == 0 ? Float.MAX_VALUE : (y[1] - x[1]) / (y[0] - (float)x[0]);
        for (int i = 1; i < coordinates.length; i++) {
            int[] a = coordinates[i];
            float tmpK = a[0]-x[0]==0?Float.MAX_VALUE: (a[1] - x[1]) / (a[0] - (float)x[0]);
            if(tmpK != k) {
                return false;
            }
        }
        return true;
    }
}
/*
方法2
*/
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1], 
            x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1))
                return false;
        }
        return true;
    }
}