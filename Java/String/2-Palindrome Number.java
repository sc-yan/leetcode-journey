Easy Leetcode 9
1517474043
tags: 

方法1:
不转换成string.

方法2:
把数字转换成字符串。
convert the input number into a string.


```
/*

*/

/*
方法1
Thoughts:
不转换成字符串。
###技巧： 通过判断原数字大于反转之后的另一半。非常巧妙
*/
class Solution {
    public boolean isPalindrome(int x) {
       if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber/10;
        
    }
}


/*
方法2
转换成字符串
!!!注意有个大坑。math.abs
*/
class Solution {
    public boolean isPalindrome(int x) {
        if (x <0) return false;
        
        String tmp = Integer.toString(x);
    
        String reverse = new StringBuffer(tmp).reverse().toString();
    
        if (reverse.equals(tmp)) return true;
        
        return false;    
        
    }
}


```