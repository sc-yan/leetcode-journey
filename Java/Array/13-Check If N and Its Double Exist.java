Easy Leetcode 1346
tags: Array

方法1:
题目不难。最我自己的思路稍微有点绕了。其实第一次思考的时候比较接近了，但是还是饶了一个小弯
方法2：
其实是最直接的方法，但是被我绕过去了



```

/*
方法1
*/
class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> set = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            set.put(arr[i], i);
        }
        for(int i = 0; i < arr.length; i++) {
            if(set.containsKey(arr[i] * 2) && i != set.get(arr[i] * 2)){
                return true;
            }
        }
        return false;
    }
}
/*
方法2
*/
public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();   
        for (int i : arr) {
            if (seen.contains(2 * i) || i % 2 == 0 && seen.contains(i / 2))
                return true;
            seen.add(i);
        }
        return false;
    }