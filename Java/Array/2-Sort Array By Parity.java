Easy Leetcode 905  acceptance rate: 70%
1517474043
tags: String
##题目不难.
方法1:
简单题目大部分都是two pointers.但是还是要注意细节
自己的思路，最最直接的思路。
需要比较全部方法。

方法2:
一个pointer固定不动。只要动，必定是被换掉。
思路更巧妙。

```

/*
方法1
*/
class Solution {
    public static int[] sortArrayByParity(int[] A) {
        if(A == null || A.length == 0 || A.length ==1 ) return A;
        int i = 0, j = A.length-1;
        int tmp;
        for (; i<j; ) {
            if(A[i]%2 ==0 && A[j]%2 !=0 ){
                i++;j--;
            } else if(A[i]%2 !=0 && A[j]%2 ==0 ){
                tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i++;j--;
            } else
            if(A[i]%2 ==0 && A[j]%2 ==0 ){
                i++;
            } else
            if(A[i]%2 !=0 && A[j]%2 !=0 ){
                j--;
            }
        }
        return A;

    }
}


/*
方法2
*/

class Solution {
    public int[] sortArrayByParity(int[] A) {
       int temp;
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                temp = A[i];
                A[i++] = A[j];
                A[j] = temp;;
            }
        return A;
    }
}
/*
方法3
正则表达式
*/
