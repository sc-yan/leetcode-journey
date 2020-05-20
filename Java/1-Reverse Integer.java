Easy Leetcode 7
1517474043
tags: 

方法1:
pop头部的第一个数字，push到末尾
pop the first digit of the input number and push it to the end.

方法2:
把数字转换成字符串。
convert the input number into a string.
注意有个大坑
重点注意的是：

Math.abs(Integer.MIN_VALUE);  //-2147483648
Math.abs(Long.MIN_VALUE);  //-9223372036854775808

```
/*

*/

/*
方法1
Thoughts:
参考了别人的答案。
*/

class Solution {
    public int reverse(int x) {
    
    if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;
    
    long rev = 0;
	int tmp = Math.abs(x); //不取绝对值也可以
	
    while(tmp != 0){
    	rev = (rev * 10) + tmp % 10;
    	tmp /= 10;
    }
    
    if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) return 0;
    
    return (int)(x < 0 ? -rev : rev);
    }
    
}

/*
方法2
转换成字符串
!!!注意有个大坑。math.abs
*/

class Solution {
    public int reverse(int x) {
    
    if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;
	
	long rev = 0;
    String tmp = Long.toString(Math.abs((long)x));
    
    String reverse = new StringBuffer(tmp).reverse().toString();
    
    rev = Long.parseLong(reverse); 
    
    if( rev > (long)Integer.MAX_VALUE || rev < (long)Integer.MIN_VALUE
      ) return 0;
    
    return (int)(x < 0 ? -rev : rev);
    }
    
}


```