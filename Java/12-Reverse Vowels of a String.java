Easy Leetcode 345
1517474043
tags: String
##题目不难.
方法1:
自己做的，会超时

方法2:
网上的参考，巧妙地用indexOf来判断是否含有vowel


```
/*

*/

/*
方法1
基本的two pointers

### 
*/
import java.util.HashMap;
import java.util.Map;
class Solution {
    public String reverseVowels(String s) {
        HashMap<Character,String> vowel = new HashMap();
        vowel.put('a', "1");
        vowel.put('e', "1");
        vowel.put('i', "1");
        vowel.put('o', "1");
        vowel.put('u', "1");
        vowel.put('A', "1");
        vowel.put('E', "1");
        vowel.put('I', "1");
        vowel.put('O', "1");
        vowel.put('U', "1");

        if (s.length() == 0) return "";
        char tmp;
        char[] ss = s.toCharArray();
        int head = 0, tail = ss.length-1;
        for (int i = 0; head < tail; i++) {
            if(vowel.containsKey(ss[head]) &&vowel.containsKey(ss[tail])  ) {
                tmp = ss[head];
                ss[head] = ss[tail];
                ss[tail] = tmp;
                head++;tail--;
            }
            if(vowel.containsKey(ss[head])&& !vowel.containsKey(ss[tail]) ){
                tail--;
            }
            if(!vowel.containsKey(ss[head])&& vowel.containsKey(ss[tail]) ){
                head++;
            }
            if(!vowel.containsKey(ss[head])&& !vowel.containsKey(ss[tail]) ){
                head++;tail--;
            }


        }
        String res = new String(ss);
        return res;
    }
}


/*
方法2
用indexOf来判断是否含有vowel
*/
public class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); i++)
        {
            if ("AEIOUaeiou".indexOf(s.charAt(i)) != -1)
            {
                while (j >= 0 && "AEIOUaeiou".indexOf(s.charAt(j)) == -1)
                {
                    j--;
                }
                sb.append(s.charAt(j));
                j--;
            }
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    }
    
    




```