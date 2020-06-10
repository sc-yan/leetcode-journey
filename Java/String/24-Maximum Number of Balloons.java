Easy 1189. Maximum Number of Balloons

tags: String

方法1:
自己的方法， 就是实现的不是很优雅。

方法2:
y又是think out of box的解法。既然balloon是成个出现的，我只
要计算能够组成最少balloon的字母就可以了。比如我有1个b，两个a，那最多只能组成一个balloon



```

/*
方法1
*/

public int maxNumberOfBalloons(String text) {
       StringBuilder sb = new StringBuilder(text);
        String bool = "balloon";
        int res = 0;
        boolean flag = true;
        while(flag) {
            for (int i = 0; i < bool.length(); i++) {
                String tmp = String.valueOf(bool.charAt(i));
                int index = sb.indexOf(tmp);
                if(index >= 0) {
                    sb.deleteCharAt(index);
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                res++;
            }
        }
        return res; 
    }

/*
方法2
*/

public static int maxNumberOfBalloons(String text) {
        int[] chars = new int[26]; //count all letters
        for (char c : text.toCharArray()) {
            chars[c - 'a']++;
        }
        int min = chars[1];//for b
        min = Math.min(min, chars[0]);//for a
        min = Math.min(min, chars[11] / 2);// for l /2
        min = Math.min(min, chars[14] / 2);//similarly for o/2
        min = Math.min(min, chars[13]);//for n
        return min;
    }