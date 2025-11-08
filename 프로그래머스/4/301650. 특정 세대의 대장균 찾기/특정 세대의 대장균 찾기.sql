-- 코드를 작성해주세요
select e3.id from ECOLI_DATA e1, ECOLI_DATA e2, ECOLI_DATA e3
where e1.parent_id is null and e1.id = e2.parent_id and e2.id = e3.parent_id
order by e3.id asc