Easy Leetcode 1435. Create a Session Bar Chart

tags: SQL, Database

方法1: 这里需要用到临时表。就是直接用select选出一个表

//方法1

SELECT '[0-5>' AS 'bin', SUM(duration/60 < 5) AS 'total'
FROM Sessions
UNION
SELECT '[5-10>' AS 'bin', SUM(duration/60 >= 5 AND duration/60 < 10) AS 'total'
FROM Sessions
UNION
SELECT '[10-15>' AS 'bin', SUM(duration/60 >= 10 AND duration/60 < 15) AS 'total'
FROM Sessions
UNION
SELECT '15 or more' AS 'bin', SUM(duration/60 >= 15) AS 'total'
FROM Sessions

// 2nd solution   using case when

SELECT '[0-5>' AS bin, SUM(CASE WHEN duration >= 0 AND duration < 300 THEN 1 ELSE 0 END) AS total FROM Sessions UNION 
SELECT '[5-10>' AS bin, SUM(CASE WHEN duration >= 300 AND duration < 600 THEN 1 ELSE 0 END) AS total FROM Sessions  UNION 
SELECT '[10-15>' AS bin, SUM(CASE WHEN duration >= 600 AND duration < 900 THEN 1 ELSE 0 END) AS total FROM Sessions UNION 
SELECT '15 or more' AS bin, SUM(CASE WHEN duration >= 900 THEN 1 ELSE 0 END) AS total FROM Sessions 
