Easy Leetcode 917
1517474043
tags: String

方法1:
反转的问题，记得用stack解决

方法2:
每到行末，就换行

方法3:
brilliant! 一步直接转换二维数组

方法4：
更进一步!!!!

```

/*
方法1
*/
class Solution {
    public String reverseOnlyLetters(String S) {
       Stack<Character> letters = new Stack();
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                letters.push(c);

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }
        return ans.toString();
    }
    
}


/*
方法2
*/

class Solution {
    public String reverseOnlyLetters(String S) {
        if(S.length() == 0 || S.length() ==1) return S;
        int a=0,b=S.length()-1;
        char A;
        char B;
        char[] res = new char[S.length()];
        for (; a <= b; ) {
            A = S.charAt(a);
            B = S.charAt(b);
            if(isDigit(A) && isDigit(B) ){
                res[a] = B; res[b] = A;
                a++;b--;
            }
            if(isDigit(A) && !isDigit(B) ){
                res[b] = B;
                b--;
            }
            if(!isDigit(A) && isDigit(B) ){
                res[a] = A; a++;
            }
            if(!isDigit(A) && !isDigit(B) ){
                res[a] = A; res[b] = B;
                a++;b--;
            }
        }
        return  String.valueOf(res);

    }
    public static boolean isDigit(char x){
        if((x<='Z'&&x>='A') || (x<='z'&&x>='a')) return true;
        return false;

    }
    
}






