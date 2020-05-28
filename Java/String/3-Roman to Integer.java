Easy Leetcode 9
1517474043
tags: 

方法1:
遍历。

方法2:
用hashmap


```
/*

*/

/*
方法1
Thoughts:
常规思路。遍历
###技巧： 不需要判断每个位数后面的位数。通过相减，来避免多余的判断。
*/
class Solution {
    public int romanToInt(String s) {
        int nums[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X' :
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1])
                sum-=nums[i];
            else
                sum+=nums[i];
        }
        return sum+nums[nums.length-1];
    }
}


/*
方法2
用hashmap.
技巧：从右往左计算。非常brilliant
*/
class Solution {
    public int romanToInt(String s) {
        
        int len = s.length();
        int sum=0;
        char[] chars = s.toCharArray();
        
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);      
        map.put('D',500);
        map.put('M',1000);        
                
        for(int i=len-1;i>=0;i--){
            if(map.get(chars[i])>=sum || chars[i]==chars[i+1])
                sum=sum+map.get(chars[i]);
            else
                sum=sum-map.get(chars[i]);
        }
        
        return sum;
    }
}


```