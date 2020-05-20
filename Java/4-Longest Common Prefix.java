Easy Leetcode 14
1517474043
tags: 

方法1:
取第一个和第二个的common，然后继续和后面取common。仍然属于遍历

方法2:



```
/*

*/

/*
方法1
Thoughts:
常规思路。遍历
### 注意一下空数组
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String tmp;
        if(strs == null || strs.length ==0){
            return "";
        }
        if (strs.length ==1){
            return strs[0];
        }
        tmp = commonPrefix(strs[0],strs[1]);
        //String res = "";

        for (int i = 0; i < strs.length; i++) {
            tmp = commonPrefix(tmp, strs[i]);
        }

        return tmp;
    }
    
    public String commonPrefix(String x, String y){
        if(x == "" || y == "" || x==null || y == null){
            return x;
        }
        for (int i = 0; i < x.length(); i++) {
            if (i < y.length()) {
                if (x.charAt(i) != y.charAt(i)) {
                    return x.substring(0,i);
                }
            } else{
                return y;
            }
        }
    return x;
    }
}


/*
方法2

*/



```