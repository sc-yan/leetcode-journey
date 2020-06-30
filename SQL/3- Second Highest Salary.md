
Easy Leetcode 176. Second Highest Salary

tags: SQL, Database

方法1:
第一反应应该想到排序的。



```

/*
方法1
*/
```
select (
  select distinct Salary from Employee order by Salary Desc limit 1 offset 1
)as SecondHighestSalary 

```


方法2:
选第二大的。其实我一开始也用的这个方法，但是一次没有写对。



```

/*
方法2
*/
```
SELECT max(Salary) as SecondHighestSalary 
FROM Employee
WHERE Salary < (SELECT max(Salary) FROM Employee)

```




