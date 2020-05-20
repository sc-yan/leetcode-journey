Easy Leetcode 922  acceptance rate: 70%
1517474043
tags: String
##题目不难.
方法1:
以前的老思路。一个挨一个检查。缺点就是需要满足好几个条件。

方法2:
老思路的优化版。我从奇数列里面，找偶数，把它换给偶数位。

```

/*
方法1
*/
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if(A == null || A.length == 0) return  A;
        int temp;
        for (int i = 0, j = 0; j < A.length; ) {
            if ((A[j] % 2 == 0 && i % 2 == 0) || (i % 2 != 0 && A[j] % 2 != 0)) {
                temp = A[i];
                A[i++] = A[j];
                A[j] = temp;
                j = i+1;
            }else{
                j++;
            }
        }
        return A;
    }
}


/*
方法2
*/

class Solution {
    public static int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2)
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1)
                    j += 2;
                // Swap A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        return A;
	}
}
