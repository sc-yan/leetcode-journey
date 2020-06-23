Easy Leetcode 1331. Rank Transform of an Array
tags: Array

方法1:
题目不难，思路比较直观，就是用hashmap了。然后我这次又没有巧妙的实现。
方法2：
答案巧妙的用了hashmap的API

```

/*
方法1
*/
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length == 0) return arr;
         int[] clone = arr.clone();
          Arrays.sort(clone);
          HashMap<Integer, Integer> map = new HashMap<>();
          int index = 1;
        map.put(clone[0], index);
        for (int i = 1; i < clone.length; i++) {
            if(clone[i] != clone[i-1]){
                map.put(clone[i-1], index);
                map.put(clone[i], index + 1);
                index++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
/*
方法2
*/
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int x : sortedArr) rank.putIfAbsent(x, rank.size() + 1);
        for (int i = 0; i < arr.length; ++i) arr[i] = rank.get(arr[i]);
        return arr;
    }