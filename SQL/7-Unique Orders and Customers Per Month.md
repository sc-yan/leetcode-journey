

Easy Leetcode 1565. Unique Orders and Customers Per Month

tags: SQL, Database

方法1: 比较直接的思路，选择就是了

/*
方法1
*/
# Write your MySQL query statement below
select substr(order_date, 1, 7) as month,count(*) as order_count, count(distinct customer_id) as customer_count
from orders where invoice > 20
group by month;
