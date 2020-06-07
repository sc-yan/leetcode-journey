Easy 1417. Reformat The String

tags: String

方法1:
自己的方法， 就是实现的不是很优雅。

方法2:
思路和我大致是一样的，不过第一遍循环的时候，就直接把char们存下来了，可以直接用



```

/*
方法1
*/

class Solution {
    public String reformat(String s) {
        int num = 0, alpha = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(tmp >= '0' && tmp <= '9') {
                num++;
            }else{
                alpha++;
            }
        }
        if(Math.abs(num - alpha) > 1) {
            return "";
        }
        int count = num > alpha ? 0 : 1;
        StringBuilder x = new StringBuilder(s);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); count++, i++) {
            if(count % 2 == 0) {
                res.append(getNumAlpha(x, isNum(x)));
            }else{
                res.append(getNumAlpha(x, isAlphabet(x)));
            }
        }
        return res.toString();
    }
    public int isNum(StringBuilder x) {
        for (int i = 0; i < x.length(); i++) {
            char tmp = x.charAt(i);
            if(tmp >= '0' && tmp <= '9') {
                return i;
            }
        }
        return -1;
    }

    public int isAlphabet(StringBuilder x) {
        for (int i = 0; i < x.length(); i++) {
            char tmp = x.charAt(i);
            if(tmp >= 'a' && tmp <= 'z') {
                return i;
            }
        }
        return -1;
    }
    
    public char getNumAlpha(StringBuilder sb, int i) {
          char res = sb.charAt(i);
          sb.deleteCharAt(i);
          return res;
    }
}

/*
方法2
*/

public String reformat(String s) {
        if(s == null || s.length()<=1)
            return s; 
        List<Character> digits = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)) digits.add(c);
            else chars.add(c);
        }
        if(Math.abs(digits.size()-chars.size()) >= 2) return "";
        
        StringBuilder sb = new StringBuilder();
        boolean digitOrChar = (digits.size()>=chars.size()) ? true : false; 
        for(int i = 0; i<s.length(); i++){
            if(digitOrChar)
                sb.append(digits.remove(0));
            else
                sb.append(chars.remove(0));
            digitOrChar = !digitOrChar; 
        }
        return sb.toString(); 
    }