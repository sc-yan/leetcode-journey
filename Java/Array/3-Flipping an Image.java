Easy Leetcode 905  acceptance rate: 70%
1517474043
tags: String
##题目不难.
方法1:
题目很简单。没啥难度。

方法2:
又是一个非常巧妙的解法。两边对称比，其实反转再互换，等于不变。所以不用改动。
只修改对称相等的情况就可以了。
注意 i * 2 < n 非常巧妙地把奇数个数的最中间的元素包含了！巧妙！！

```

/*
方法1
*/
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null || A.length == 0  ) return A;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if(A[i][j] == 0) {
                    A[i][j] =1;
                }else
                if(A[i][j] == 1) A[i][j] =0;
            }
            for (int j = 0; j < A[i].length/2; j++) {
                int tmp = A[i][j];
                A[i][j] = A[i][A[i].length -1 -j];
                A[i][A[i].length -1 -j] = tmp;
            }
        }
        return  A;
    }
}


/*
方法2
*/

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int[] row : A)
            for (int i = 0; i * 2 < n; i++)
                if (row[i] == row[n - i - 1]){
                    row[i] = row[n - i - 1] ^= 1;
                }
                    
        return A;
    }
}
/*
方法3
正则表达式
*/
