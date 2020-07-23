
Easy Leetcode 1173. Immediate Food Delivery I

tags: SQL, Database

方法1:
比较直接的方法，就是把两个数字选出来，然后相处
方法2：
貌似可以直接用表达式计算，不用分成两个表



```
/*
方法1
*/
```
# Write your MySQL query statement below
select round((select count(*) from delivery D
where D.order_date = D.customer_pref_delivery_date ) /
(select count(*) from delivery) * 100  , 2) as immediate_percentage

```


```
SELECT ROUND(100*AVG(order_date = customer_pref_delivery_date), 2) AS immediate_percentage
FROM Delivery;

select round(100 * sum(order_date = customer_pref_delivery_date) / count(*), 2) as immediate_percentage from Delivery;



