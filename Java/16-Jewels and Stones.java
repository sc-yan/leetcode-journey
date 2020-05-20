Easy Leetcode 771
1517474043
tags: String
##题目不难.
方法1:
自己的方法，最弱智的方法

方法2:
brilliant!!用了正则表达式的反义匹配。

方法3:
本来也想用hashset的，但是一时思路没想好，用了最简单的。一定要学会多用hashset

```

/*
方法1
*/
class Solution {
    public int numJewelsInStones(String J, String S) {
        int sum = 0;
        for (int i = 0; i < J.length(); i++) {
            char jewel = J.charAt(i);
            for (int j = 0; j < S.length(); j++) {
                if(jewel == S.charAt(j)){
                    sum++;
                }
            }
        }
        return sum;
    }
}


/*
方法2
*/
public int numJewelsInStones(String J, String S) {
    return S.replaceAll("[^" + J + "]", "").length();
}
/*
方法3
hashset
*/

public int numJewelsInStones(String J, String S) {
    int res = 0;
    Set setJ = new HashSet();
    for (char j: J.toCharArray()) setJ.add(j);
    for (char s: S.toCharArray()) if (setJ.contains(s)) res++;
    return res;
}
方法3
三哥的思路，不是从S里面找J。而是从J里面找S。其实和hash差不多。hash实现起来更快一些。
*/

public static int numJewelsInStones(String J, String S) {
    int res=0;
    for(char c : S.toCharArray()){
        if(J.indexOf(c) != -1){
            res++;
        }
    }
    return res;
}