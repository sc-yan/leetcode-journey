Easy 1103. Distribute Candies to People

tags: 
array

思路
方法1： intuitive的思路，就是模拟每一步操作。
方法2：非常优雅的代码。取余数方法取代了我需要每次记录n，用Math.min的方法取代了我
放最后一个数字的情况。

方法1:

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
          int n = 1;
          while(candies >= n){
              for (int i = 0; i < num_people; i++) {
                  res[i] += n;
                  candies -= n;
                  n++;
                  if(candies < n)  {
                      if(i <= num_people-2) {
                          res[i+1] += candies;
                      }else{
                          res[0] += candies;
                      }
                      
                      break;
                  }
              }
          }
          return res;
    }
}

方法2:

```
/*

*/
public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        for (int give = 0; candies > 0; candies -= give) {
            people[give % num_people] +=  Math.min(candies, ++give);
        }
        return people;
    }
