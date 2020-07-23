
Easy Leetcode 1484. Group Sold Products By The Date

tags: SQL, Database

方法1:
卡在如何拼接字符串了。用IDE的时候看到了那个group cat，估计就是，果然。



```
/*
方法1
*/
```
# Write your MySQL query statement below
select sell_date, count(distinct product) as num_sold , 
group_concat(distinct product order by product asc separator ',') as products               
from activities  
group by sell_date
order by sell_date

```


```





