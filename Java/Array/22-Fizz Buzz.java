Easy Leetcode 1331. Rank Transform of an Array
tags: Array

方法1:
题目不难，但是如何把程序设计的scalable是非常巧妙的。`
方法2：
收录一个js的答案。和java对比，立马能体现出es6的特性。
方法3：
转换一下思路。并不是去判断每个数去取余。而是count 3和5的次数。开销明显小了很多`
```

/*
方法1
*/
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            int j = i + 1;
            if(j % 3 == 0 && j % 5 == 0) {
                res.add("FizzBuzz");
            }else{
                if(j % 3 == 0) {
                    res.add("Fizz");
                }else if(j % 5 == 0){
                    res.add("Buzz");
                }else{
                    res.add("" + j);
                }
            }
        }
        return res;
    }
}
/*
方法2
*/
 fizzBuzz = n => new Array(n).fill(0).map(
    (a, i) => (++i % 3 ? '' : 'Fizz') + (i % 5 ? '' : 'Buzz') || '' + i
    )
/*
方法3
*/

 public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>(n);
        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
            fizz++;
            buzz++;
            if(fizz==3 && buzz==5){
                ret.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }else if(fizz==3){
                ret.add("Fizz");
                fizz=0;
            }else if(buzz==5){
                ret.add("Buzz");
                buzz=0;
            }else{
                ret.add(String.valueOf(i));
            }
        } 
        return ret;
    }
}

//  
//easy for gc
private String FIZZ = "Fizz";
private String BUZZ = "Buzz";
private String FIZZ_BUZZ = "FizzBuzz";

public List<String> fizzBuzz(int n) {
    List<String> res = new ArrayList();
    for(int i = 1; i <= n; i++){
        //remove if else, make code shorter
        String temp = i % 15 == 0 ? FIZZ_BUZZ : (i % 3 == 0 ? FIZZ : (i % 5 == 0 ?  BUZZ : String.valueOf(i)));
        res.add(temp);
    }
    return res;
}

// 4

import java.util.*;

public class Solution {
    private final Map<Rule, String> ruleContainers = new HashMap<>();
    private final Set<Rule> rules  = new HashSet<>();
    public Solution() {
        addRule(i -> i % 15 == 0, "FizzBuzz");
        addRule(i -> i % 3 == 0, "Fizz");
        addRule(i -> i % 5 == 0, "Buzz");
    }
    public void addRule(Rule rule, String res) {
        rules.add(rule);
        ruleContainers.put(rule, res);
    }
    public String getValue(int i) {
        for (Rule rule : rules) {
            if (rule.apply(i)) {
                return ruleContainers.get(rule);
            }
        }
        return String.valueOf(i);
    }

    //then the origin code should be as follows:
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            res.add(getValue(i));
        }
        return res;
    }
    public static void main(String[] args) {
        int[] s = {7,1,14,11};
        Solution x = new Solution();
        x.fizzBuzz(5);
    }
}
