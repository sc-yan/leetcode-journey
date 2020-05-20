Easy Leetcode 58
1517474043
tags: String
##非常简单的一个题目。
方法1:
自己做的，用的split()方法

方法2:
网上的参考，用的lastIndexOf()


```
/*

*/

/*
方法1
Thoughts:
遍历 iteration
### 
*/
class Solution {
    public int lengthOfLastWord(String s) {
       if(s == null || s.length() ==0){
            return 0;
        }
        String x[] = s.split("\\s+");
        if(x.length ==0) {
            return 0;
        }
        return x[x.length-1].length(); 
    }
}


/*
方法2
lastIndexOf()
*/
class Solution {

    public static int lengthOfLastWord(String s) {
        int a = s.trim().length();
        int b =  s.trim().lastIndexOf(" ");
        return a-b-1;

        //return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}


```