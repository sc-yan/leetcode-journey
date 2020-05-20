Easy Leetcode 566
1517474043
tags: Array

方法1:
用queue解决

方法2:
每到行末，就换行

方法3:
brilliant! 一步直接转换二维数组

方法4：
更进一步!!!!

```

/*
方法1
*/
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int count = 0;
        Queue <Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                queue.add(nums[i][j]);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.remove();
            }
        }
        return res;
    }
}


/*
方法2
*/

/*
方法3
brilliant!!! 
*/


class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return res;
    }
}

/*
方法4
brilliant!!! 
*/

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
    if (r * c != m * n)
        return nums;
    int[][] reshaped = new int[r][c];
    for (int i = 0; i < r * c; i++)
        reshaped[i/c][i%c] = nums[i/n][i%n];
    return reshaped;
    }
}