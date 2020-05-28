Easy Leetcode 383
1517474043
tags: String
##题目不难.
方法1:
思路就是把每一个字符取出来，然后累加个数。然后再去比较

方法2:
思路和方法1一样。只不过只考虑小写字母。不够全面。


```
/*

*/

/*
方法1
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> maga=new ArrayList<>();
        for(Character c:magazine.toCharArray()) maga.add(c);
        for(Character c:ransomNote.toCharArray()){
            if(!maga.contains(c)){return false;}
            else{
                maga.remove(maga.indexOf(c));
            }
        }
        return true;
    }
}


/*
方法2
用indexOf来判断是否含有vowel
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}