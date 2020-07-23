
Easy Leetcode 1303. Find the Team Size

tags: SQL, Database

方法1:
很简单的左连接就能搞定
方法2:
window函数。需要注意只有mysql 8.0之后才支持这个函数



```
/*
方法1
*/
```
# Write your MySQL query statement below
select A.employee_id, count(A.team_id) as team_size from employee A left join employee B
on A.team_id = B.team_id group by A.employee_id

```


```

/*
方法2
*/
```
select employee_id, 
    count(employee_id) over(partition by team_id) as team_size
from employee

select employee_id, count(*) over(partition by team_id) as team_size
from employee

```




