Easy Leetcode 387
1517474043
tags: String
##题目不难.
方法1:
自己的方法，一开始time exceed,然后又改进了一点，还是超时。
整体思路比较直接。

方法2:
无敌的解法。。

方法3:
用正则表达式

```

/*
方法1
*/
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len ==1) return false;
        String com = "";
        for (int i = 1; i <= len/2; i++) {
            com += s.charAt(i-1);
            for (int j = i; j <= len; j+=i) {
                int xx = s.indexOf(com, j);
                if( xx !=j ){
                    break;
                }
                if(j == len-i) return true;
            }

        }
        return false;
    }
}


/*
方法2
*/
class Solution {
    public boolean repeatedSubstringPattern(String str) {
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }
}
/*
方法3
正则表达式
*/

public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        return str.matches("(.+)\\1+");
    }
}