Easy Leetcode 205. Isomorphic Strings
tags: Array

方法1:
题目不难，就是计算出现频率。我用的map
方法2：
用的array
方法3：
fucking genius


```

/*
方法1
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        boolean res = true;
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            // has key
            if(map.get(sChar) != null){
                if(tChar != map.get(sChar)){
                    res = false;break;
                }
                // no key-value
            }else{
                if(set.contains(tChar)){
                    res = false;break;
                }
                map.put(sChar,tChar);
                set.add(tChar);
            }
        }
        return res;
    }
}
/*
方法2
*/
 class Solution {
public:
    bool isIsomorphic(string s, string t) {
        int m1[256] = {0}, m2[256] = {0}, n = s.size();
        for (int i = 0; i < n; ++i) {
            if (m1[s[i]] != m2[t[i]]) return false;
            m1[s[i]] = i + 1;
            m2[t[i]] = i + 1;
        }
        return true;
    }
};


/*
方法3
*/
public boolean isIsomorphic(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
    
        for(Integer i = 0; i < s1.length(); i++) {

            if(m1.put(s1.charAt(i), i) != m2.put(s2.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }