Easy Leetcode 125
1517474043
tags: String
##题目不难，但是容易timeexceed。需要考虑如何降低时间复杂度
方法1:
自己做的，会超时

方法2:
网上的参考，非常直观的方法。把string倒过来

方法3:
最主流的方法，two pointers。从两头往中间比较

方法4:
也是一个很巧妙的办法，通过建立一个char的array，来avoid大小写的check
```
/*

*/

/*
方法1
Thoughts:

### 
*/
class Solution {
    public  boolean isNum(char x) {
        if(48<= x && x<=57 ) return true;
        return false;
    }
    public  boolean isAlpha(char x) {
        if(65<= x && x<=90 ) return true;
        if(97<= x && x<=122 ) return true;
        return false;
    }
    public  boolean isEqual(char x, char y) {
        if(isNum(x)&&isNum(y)){
            return x==y;
        }
        if(isAlpha(x)&&isAlpha(y)){
            if(x ==y || x-y==32 || y-x==32 ){
                return true;
            }
        }
        return false;
    }

    public  boolean isPalindrome(String s) {
        boolean flag = true;
        if(s.length() ==0) return true;
        String ss = "";
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if(isAlpha(x)||isNum(x)) ss += ""+x;
        }
        if(ss.length() == 0 || ss.length() ==1) return  true;
        for (int i = 0; i < ss.length()/2; i++) {
            char x = ss.charAt(i);
            char y = ss.charAt(ss.length()-i-1);
            if(!isEqual(x,y)){
                flag = false;
                break;
            }
        }
        return  flag;


    }
}


/*
方法2
非常直观的方法
*/
class Solution {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
}
/*
方法3
two pointers
*/

public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);
        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}
        		head++;
        		tail--;
        	}
        }
        
        return true;
    }
}
/*
方法4

*/
public class Solution {
    private static final char[]charMap = new char[256];
 static{
     for(int i=0;i<10;i++){
         charMap[i+'0'] = (char)(1+i);  // numeric
     }
     for(int i=0;i<26;i++){
         charMap[i+'a'] = charMap[i+'A'] = (char)(11+i);  //alphabetic, ignore cases
     }
 }
 public boolean isPalindrome(String s) {
     char[]pChars = s.toCharArray();
     int start = 0,end=pChars.length-1;
     char cS,cE;
     while(start<end){
         cS = charMap[pChars[start]];
         cE = charMap[pChars[end]];
         if(cS!=0 && cE!=0){
             if(cS!=cE)return false;
             start++;
             end--;
         }else{
             if(cS==0)start++;
             if(cE==0)end--;
         }
     }
     return true;
 }
 }

```