Easy Leetcode 1441  
tags: Array

方法1:
题目不难。自己的思路又是纯直接式的。以后需要多思考一下如何优化算法。
方法2：
思路不错。更规整一些


```

/*
方法1
*/
//import java.util.stream.IntStream;
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new LinkedList<>();
        for (int i = 1; i <=n; i++) {
            int finalI = i;
            boolean contains = IntStream.of(target).anyMatch(x -> x == finalI);
            if(contains) {
                
                res.add("Push");
            }else{
                if(i > target[target.length-1]){
                    break;
                }
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }
}


/*
方法2
*/
public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int j=0;
        for (int i=1;i<=n && j<target.length;i++) {
            result.add("Push");
            if(target[j]==i) {
                j++;
            } else {
                result.add("Pop");
            }
        }
        return result;
    }