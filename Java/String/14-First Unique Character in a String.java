Easy Leetcode 387
1517474043
tags: String
##题目不难.
方法1:
思路就是把每一个字符取出来，放进map里，然后放个数。然后再遍历一遍string，看谁是第一个个数为1的字符。

方法2:
用indexOf来判断

方法3:
用linkedHashmap.(比hashmap多了一个顺序的功能)

```

/*
方法1
*/
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
       for (char x:s.toCharArray()) {
            count.put(x, count.getOrDefault(x,0)+1);
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }
}


/*
方法2
*/
class Solution {
    public int firstUniqChar(String s) {
        char[] a = s.toCharArray();
		
		for(int i=0; i<a.length;i++){
			if(s.indexOf(a[i])==s.lastIndexOf(a[i])){return i;}
		}
		return -1;
    }
}
/*
方法3
linkedHashmap
*/

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (map.get(s.charAt(i)) != null) {
                    map.remove(s.charAt(i));
                }
            } else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }
}