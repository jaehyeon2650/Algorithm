-- 코드를 작성해주세요
with new_table as(SELECT NTILE(4) OVER (ORDER BY size_of_colony ASC) AS NUM, id 
FROM ecoli_data)

select id,(case when num=1 then 'LOW'
when num=2 then 'MEDIUM'
when num=3 then 'HIGH'
else 'CRITICAL'
end) as colony_name from new_table order by id asc

