-- 코드를 입력하세요
select * from places
where host_id in 
(SELECT host_id from places
group by host_id
having count(*) >= 2)
order by id