Easy Leetcode 1184
tags: Array

方法1:
题目不难。想到了最优解决思路。就是把总长度减去一个方向。但是实现的时候不够优雅
方法2：
非常优雅的实现方式，一遍循环就足够了。我用了两遍


```

/*
方法1
*/
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for (int value : distance) {
            sum += value;
        }
        int dis1 = 0;
        if(start > destination) {
            int tmp = destination;
            destination = start;
            start = tmp;
        }
        for (int i = start; i < destination; i++) {
            dis1 += distance[i];
        }
        return Math.min(dis1, sum - dis1);
    }
}
/*
方法2
*/
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;;
        }
        int res = 0, total = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                res += distance[i];
            }
            total += distance[i];
        }
        return Math.min(res, total - res);
    }
}