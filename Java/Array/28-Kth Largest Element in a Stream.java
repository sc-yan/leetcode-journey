Easy Leetcode 703. Kth Largest Element in a Stream
tags: Array Design

方法1:
一看到最大几个，或者最小几个，就应该考虑到priorityQueue或者treeMap

```

/*
方法1
*/
class KthLargest {
    final PriorityQueue<Integer> queue;
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int n: nums) add(n);
    }
    public int add(int n) {
        if (queue.size() < k) {
            queue.offer(n);
        } else if (queue.peek() < n) {
            queue.poll();
            queue.offer(n);
        }
        return queue.peek();
    }
}
