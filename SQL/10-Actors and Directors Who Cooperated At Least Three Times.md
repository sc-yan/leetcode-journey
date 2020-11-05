Easy Leetcode 1050. Actors and Directors Who Cooperated At Least Three Times

tags: SQL, Database

方法1: just easy peasy

//方法1


# Write your MySQL query statement below
select actor_id, director_id from actordirector group by actor_id, director_id
having count(*) >=3
