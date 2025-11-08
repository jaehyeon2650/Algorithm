-- 코드를 작성해주세요
with recursive result as (
    select 
        id,
        parent_id,
        1 as generation 
    from ECOLI_DATA
    where parent_id is null
    
    union all
    
    select 
        e.id,
        e.parent_id,
        r.generation + 1
    from ECOLI_DATA e, result r
    where r.id = e.parent_id
)
SELECT count(*) as count, generation
FROM result r1
WHERE r1.id NOT IN (SELECT DISTINCT parent_id FROM result r2 where parent_id is not null)
group by generation
order by generation asc





