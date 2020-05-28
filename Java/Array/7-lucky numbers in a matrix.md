Easy Leetcode 1380  
1517474043
tags: Array

[lucky numvers in a matrix](https://leetcode.com/problems/lucky-numbers-in-a-matrix/)

方法1:
命令式解题。先找最大值，再找最小值。我的解法
方法2：
通过数学证明，这样的数字之恶能存在一个



    /*
    方法1
    */
    class Solution {
        public List<Integer> luckyNumbers (int[][] matrix) {
            int m = matrix.length;
            List<Integer> result = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                int[] row = matrix[i];
                int index = findMin(row);
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if(matrix[j][index]  > matrix[i][index]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    result.add(matrix[i][index]);
                }
    
            }
            return result;
        }
        
        public static int findMin(int[] x) {
              int min = x[0];
              int index = 0;
              for(int i = 0; i < x.length; i++) {
                  if(x[i] < min) {
                      min = x[i];
                      index = i;
                  }
              }
              return index;
        }
    }
    
    
    /*
    方法2
    */
        public List<Integer> luckyNumbers (int[][] matrix) {
            Set<Integer> minSet = new HashSet<>(), maxSet = new HashSet<>();
            for (int[] row : matrix) {
                int mi = row[0];
                for (int cell : row)
                    mi = Math.min(mi, cell);
                minSet.add(mi);
            }
            for (int j = 0; j < matrix[0].length; ++j) {
                int mx = matrix[0][j];
                for (int i = 0; i < matrix.length; ++i)
                    mx = Math.max(matrix[i][j], mx);
                if (minSet.contains(mx))
                    maxSet.add(mx);
            }
            return new ArrayList<>(maxSet);        
        }

