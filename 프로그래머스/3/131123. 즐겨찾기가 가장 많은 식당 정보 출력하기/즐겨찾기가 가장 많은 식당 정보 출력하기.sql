-- 코드를 입력하세요
select food_type,rest_id,rest_name,favorites from rest_info where rest_name in
(SELECT rest_name from rest_info i2 group by rest_name,food_type
having sum(favorites)=(select max(t.sums) from (SELECT sum(favorites) as sums from rest_info group by rest_name,food_type having food_type=i2.food_type) as t))
order by food_type desc