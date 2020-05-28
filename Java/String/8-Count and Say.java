Easy Leetcode 38
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
class Solution {
    public static int count(String x) {
        if(x.length() == 0){
            return 0;
        }

        int l = x.length();
        int c = 1;
        char m = x.charAt(0);
        for (int i = 1; i < l; i++) {
            if(x.charAt(i) == m){
                c++;
            }else{
                break;
            }
        }
        return c;
    }

    public static String countAndSay(int n) {
        if(n ==1 ){
            return "1";
        }
        String a="";
        String m = countAndSay(n-1);

        while(count(m) != 0) {
            //int c = count(m);

            for (int j = 0; j < count(m); j++) {
                a+= ""+count(m)+m.charAt(0);
                m = m.substring(count(m));
            }
        }

        return a;
    }
}


/*
方法2

*/




```