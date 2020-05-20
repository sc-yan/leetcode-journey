Easy Leetcode 28
1517474043
tags: String

方法1:
用substring

方法2:



```
/*

*/

/*
方法1
Thoughts:
遍历 iteration
### 
*/
public class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}


/*
方法2
非常巧妙
*/

class Solution {
    public int strStr(String haystack, String needle) {
       for (int i = 0; ; i++) {
           for (int j = 0; ; j++) {
               if (j == needle.length()) return i;
               if (i + j == haystack.length()) return -1;
               if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}


```