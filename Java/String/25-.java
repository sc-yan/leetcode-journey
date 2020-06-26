Easy 392. Is Subsequence

tags: String

方法1:
自己的方法， 就是实现的不是很优雅。

方法2:

binary search

```

/*
方法1
*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        int start = 0;
        boolean flag = true;
        for (char x:s.toCharArray()) {
            boolean flagNest = false;
            for (int i = start; i < t.length(); i++) {
                if(x == t.charAt(i)){
                    start = i + 1;
                    flagNest = true;
                    break;
                }
            }
            if(!flagNest){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
/*
方法2
*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int tLen = t.length();int sLen = s.length();
        while(i < sLen && j < tLen) {
            if(s.charAt(i) == t.charAt(j)) { i++;j++; }
            else j++;
        }
        return i == sLen;
    }
}