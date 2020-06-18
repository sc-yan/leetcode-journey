Easy Leetcode 1005. Maximize Sum Of Array After K Negations
tags: Array, priorityQueue

方法1:
题目不难。直接模拟每一步就可以。但是我选择了更麻烦的hashmap。其实完全不需要。直接用俩变量就完事
方法2：
就是方法1.但是我用了一个更麻烦的数据结构。有时候其实没有必要。
方法2才2ms，而我的hashmap用了12ms

```

/*
方法1
*/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);
        for (int i = 0; i < bills.length; i++) {
            int cur = bills[i];
            if(cur == 5) {
                map.put(5, map.get(5) + 1);
            }
            if(cur == 10) {
                if(map.get(5) > 0){
                    map.put(10, map.get(10) + 1);
                    map.put(5, map.get(5) - 1);
                }else{
                    return false;
                }
            }
            if(cur == 20) {
                if(map.get(5) > 0 && map.get(10) > 0){
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                    map.put(20, map.get(20) + 1);
                }else if(map.get(5) >= 3){
                    map.put(5, map.get(5) - 3);
                    map.put(20, map.get(20) + 1);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
/*
方法2
*/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
}