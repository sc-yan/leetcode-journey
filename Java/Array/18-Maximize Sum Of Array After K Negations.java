Easy Leetcode 1005. Maximize Sum Of Array After K Negations
tags: Array, priorityQueue

方法1:
题目不难。a按照常规，可以计算出来
方法2：
brilliant!用priorityQueue完美解决了K是否为奇数偶数的问题`


```

/*
方法1
*/
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int neg = 0, sum = 0;
        Arrays.sort(A);
        for (int x:A) {
            if(x < 0) neg++;
            sum += x;
        }

        int res = 0;
        // reg多K少，只反转最小的负数 K多，先反转所有负数。再取K的单数，翻最小的数
        for (int i = 0; i < Math.min(K, neg); i++) {
            A[i] = -A[i];
        }
        if(K > neg) {
            int mod = K - neg;
            mod = mod % 2;
            if(mod == 1) {
                if(neg == 0) {
                    A[neg] = -A[neg];
                }else{
                    if(A[neg -1] > A[neg]) {
                        A[neg] = -A[neg];
                    }else{
                        A[neg-1] = -A[neg-1];
                    }
                }
                
            }
            
        }
        for (int x:A) {
            res += x;
        }
        return res;
    }
}
/*
方法2
*/
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int x: A) pq.add(x);
        while( K--  > 0) pq.add(-pq.poll());
  
        int sum  = 0;
        for(int i = 0; i < A.length; i++){
            sum += pq.poll();
        }
        return sum;
    }
}