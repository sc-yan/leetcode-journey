Easy Leetcode 1160

tags: String

方法1:
自己的方法， 纯intuitive，没有用到复杂的数据结构，就是命令式解法。

方法2:
自己思考，改进之后的算法。每次都用StringBuilder太消耗资源。把判断contain改成了用hashmap。提高效率

方法3：
网友的方法。思路是一致的，只不过没有用hashmap，而是用了array去计算个数。map这种计算count类的方法，很多
都可以转为array。代码没有map清晰，但是效率高了很多。
方法2用了55ms，方法3才有9s，可见开销差距。


```

/*
方法1
*/

class Solution {
    public int countCharacters(String[] words, String chars) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            boolean flag = true;
            StringBuilder tmp = new StringBuilder(chars);
            for (int j = 0; j < word.length(); j++) {
                Character x = word.charAt(j);
                int index = tmp.indexOf(x.toString());
                if ( index>= 0) {
                    tmp.deleteCharAt(index);
                } else {
                    flag = false;
                }
            }
            if (flag) {
                result.add(word);
            }
        }
        int res = 0;
        for (String s : result) {
            res += s.length();
        }
        return res;
    }
}

/*
方法2
*/

public static int countCharacters(String[] words, String chars) {
        int res = 0;
        HashMap<Character, Integer> mapA = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char x = chars.charAt(i);
            mapA.put(x, mapA.getOrDefault(x, 0) + 1);
        }
        for (String word : words) {
            HashMap<Character, Integer> map = (HashMap<Character, Integer>) mapA.clone();
            boolean flag = true;
            for (int j = 0; j < word.length(); j++) {
                char x = word.charAt(j);
                if ( map.getOrDefault(x, 0) > 0) {
                    map.put(x, map.get(x) -1);
                } else {
                    flag = false;
                }
            }
            if (flag) {
                res += word.length();
            }
        }
        return res;
    }

/*
方法3
*/

     public static int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] seen = new int[26];
        //Count char of Chars String
        for (char c : chars.toCharArray())
            seen[c - 'a']++;
        // Comparing each word in words
        for (String word : words) {
            // simple making copy of seen arr
            int[] tSeen = Arrays.copyOf(seen, seen.length); 
            int Tcount = 0;
            for (char c : word.toCharArray()) {
                if (tSeen[c - 'a'] > 0) {
                    tSeen[c - 'a']--;
                    Tcount++;
                }
            }
            if (Tcount == word.length())
                count += Tcount;
        }
        return count;
    }




