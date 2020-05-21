
Easy Leetcode 1179

tags: SQL, Database

方法1:
To everyone wondering why you need the SUM.  
Imagine you don't use the group by and run such query:

```
SELECT id,
CASE WHEN month = "Jan" THEN revenue END as "Jan_Revenue",
CASE WHEN month = "Feb" THEN revenue END AS "Feb_Revenue"
FROM Department;

```

this will return multiple rows for each id + month pair:

```
+----+-------------+-------------+
| id | Jan_Revenue | Feb_Revenue |
+----+-------------+-------------+
|  1 |        NULL |        7000 |
|  1 |        8000 |        NULL |
|  1 |        NULL |        NULL |
|  2 |        9000 |        NULL |
|  3 |        NULL |       10000 |
+----+-------------+-------------+


```

To get one row for each id we need to aggregate by id using GROUP BY.


```

/*
方法1
*/
```
select id, 
    sum(case when month = 'jan' then revenue else null end) as Jan_Revenue,
    sum(case when month = 'feb' then revenue else null end) as Feb_Revenue,
    sum(case when month = 'mar' then revenue else null end) as Mar_Revenue,
    sum(case when month = 'apr' then revenue else null end) as Apr_Revenue,
    sum(case when month = 'may' then revenue else null end) as May_Revenue,
    sum(case when month = 'jun' then revenue else null end) as Jun_Revenue,
    sum(case when month = 'jul' then revenue else null end) as Jul_Revenue,
    sum(case when month = 'aug' then revenue else null end) as Aug_Revenue,
    sum(case when month = 'sep' then revenue else null end) as Sep_Revenue,
    sum(case when month = 'oct' then revenue else null end) as Oct_Revenue,
    sum(case when month = 'nov' then revenue else null end) as Nov_Revenue,
    sum(case when month = 'dec' then revenue else null end) as Dec_Revenue
from department
group by id
order by id

```





