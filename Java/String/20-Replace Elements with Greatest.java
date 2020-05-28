Easy Leetcode 1299

tags: Array

方法1:
这个是我自己的方法，纯粹是intuitive的。就是n遍循环

方法2:
没有从正向循环，而是从反向循环，巧妙的存储了max
利用Math.max省略了少存储一次arr[i]也很巧妙


```

/*
方法1
*/

class Solution {
    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                }
            }
            res[i] = max;
        }
        res[arr.length-1] = -1;
        return res;
    }
}

/*
方法2
*/

class Solution {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length -1; i >= 0; i--) {
            max = Math.max(arr[i], arr[i] = max);
        }
        return arr;
    }
}





