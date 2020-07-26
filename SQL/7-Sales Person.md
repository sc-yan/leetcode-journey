
Easy Leetcode 607. Sales Person

tags: SQL, Database

方法1:
比较直接的思路，用not in
方法2：
任何not in都可以转换为right join



```
/*
方法1
*/
```
SELECT s.NAME 
FROM   salesperson s 
WHERE  sales_id NOT IN(SELECT sales_id 
                       FROM   orders o 
                              LEFT JOIN company c 
                                     ON o.com_id = c.com_id 
                       WHERE  c.NAME = 'RED') 
```


```
select salesperson.name
from orders o join company c on (o.com_id = c.com_id and c.name = 'RED')
right join salesperson on salesperson.sales_id = o.sales_id
where o.sales_id is null
