Easy Leetcode 599. Minimum Index Sum of Two Lists
tags: Array

方法1:
两个数组比较，似乎也没有比较好的办法了，就是用hashmap。但是我在判断上稍微麻烦了一点
方法2：
这个答案在判断上更精巧一下些

```

/*
方法1
*/
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        TreeMap<Integer, List<String>> res = new TreeMap<>();
        for (int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int index = i + map.get(list2[i]);
                if(res.containsKey(index)){
                    List<String> tmp = res.get(index);
                    tmp.add(list2[i]);
                }else{
                    List<String> tmp = new LinkedList<>();
                    tmp.add(list2[i]);
                    res.put(index, tmp); 
                }
                
            }
        }
        List<String> tmp = res.get(res.firstKey());
                return tmp.toArray(new String[tmp.size()]);

    }
}
/*
方法2
*/
public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    List<String> res = new LinkedList<>();
    int minSum = Integer.MAX_VALUE;
    for (int i=0;i<list1.length;i++) map.put(list1[i], i);
    for (int i=0;i<list2.length;i++) {
        Integer j = map.get(list2[i]);
        if (j != null && i + j <= minSum) {
            if (i + j < minSum) { res.clear(); minSum = i+j; }
            res.add(list2[i]);
        }
    }
    return res.toArray(new String[res.size()]);
}