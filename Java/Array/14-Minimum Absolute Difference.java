Easy Leetcode 1200
tags: Array

方法1:
题目不难。但是不假思索的遍历了两遍，其实一遍就可以的
方法2：
只遍历一遍的方法。


```

/*
方法1
*/
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            min = Math.min(min, arr[i+1] -arr[i]);
        }
        for (int i = 0; i < arr.length-1; i++) {
            int tmp = arr[i+1] -arr[i];
            if(tmp == min) {
                List<Integer> x = new LinkedList<>();
                x.add(arr[i]);
                x.add(arr[i + 1]);
                res.add(x);
            }
        }
        return res;
    }
}
/*
方法2
*/
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList();
        //sort elements
        Arrays.sort(arr);
        //init our min difference value
        int min = Integer.MAX_VALUE;
        //start looping over array to find real min element. Each time we found smaller difference
        //we reset resulting list and start building it from scratch. If we found pair with the same
        //difference as min - add it to the resulting list
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min) {
                min = diff;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (diff == min) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }