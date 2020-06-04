Easy Leetcode 1394
tags: Array

方法1:
题目不难。最直观的解法
方法2：
有点巧妙的解法。排序之后又是从后往前遍历

方法3
用array存出现的次数，而不是hashmap。这种情况index就是它的出现次数

Approach 3A: Linked List (Beast Mode)

The idea is to use the input array to store counts. This approach, however, is quite tricky to implement correctly!

We can think of our array as a linked list, where arr[i] points to arr[arr[i] - 1] and so on, until the element that points to itself, or its outside of the array (and we do not care about that elements, per the intuition above).

After we visit arr[arr[i] - 1], we can use that element to track the count of arr[i]. For the count, we will use a negative value to distinguish between pointers and counts.



```

/*
方法1
*/
class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }
        int res = -1;
        for (Map.Entry<Integer,Integer> x:map.entrySet()) {
            if(x.getKey() == x.getValue()) {
                res = Math.max(res, x.getValue());
            }
        }
        return res;
    }
}

/*
方法2
*/
class Solution {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        for (int i = arr.length-2; i >=0; i--) {
            if(arr[i] == arr[i+1]) {
                count++;
            }else{
                if(count == arr[i+1]){
                    return count;
                }
                count = 1;
            }
        }
        return arr[0] == count ? count :  -1;
    }
}
/*
方法3
*/
class Solution {
    public int findLucky(int[] arr) {
        int res = -1;
        
        if (arr == null || arr.length == 0)
            return res;
        
        int[] store = new int[500+1]; // if we read the Constraints, the max length is 500
        
        for (int i = 0; i < arr.length; i++) {
            store[arr[i]]++; // increment each elements in the store arr
        }
        
        for (int i = store.length - 1; i >= 1; i--) { // iterate from the end
            if (store[i] == i) // find the max element from the end, which equals condtions of the lucky integer
                return store[i];
        }
        
        return res;
    }
}
    


public static int findLucky(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int j = i, tmp = arr[i];
            while(tmp > 0 && tmp <= arr.length) {
                int val = arr[tmp -1];
                arr[tmp -1] = Math.min(0, arr[tmp -1]) -1;
                if(tmp -1 <= i || tmp -1 == j) {
                    break;
                }
                j = tmp -1;
                tmp = val;
            }
        }
        for(int i = arr.length; i > 0; i--) {
            if(-arr[i -1] == i) {
                return i;
            }
        }
        return -1;
    }