
Easy Leetcode 196. Delete Duplicate Emails

tags: SQL, Database

方法1:
查询的思路。注意选完一次table之后，需要再选一次



```

/*
方法1
*/
```
delete from Person where Id in
(
    select Id from 
    (
        select min(Id) Id from Person group by Email HAVING count(*)>1
    ) Ids
);

```


方法2:
直接可以删除。又学习了删除的用法。不过实际运行起来发现删除比select慢了许多。删除是2556ms，
查询才用了1655ms



```

/*
方法2
*/
```
delete from Person where Id in
(
    select Id from 
    (
        select min(Id) Id from Person group by Email HAVING count(*)>1
    ) Ids
);

```




