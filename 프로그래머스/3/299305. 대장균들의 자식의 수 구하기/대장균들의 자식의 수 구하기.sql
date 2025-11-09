-- 코드를 작성해주세요

with child as(select parent_id as id, count(*) child_count from ECOLI_DATA
where parent_id is not null
group by parent_id)

select * from (select id, 0 as child_count from ECOLI_DATA
where id not in (select id from child)
union
select * from child) as temp
order by id asc