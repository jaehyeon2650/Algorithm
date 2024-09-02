-- 코드를 작성해주세요
with new_table as(select case when (d.skill_code&(select sum(code) from skillcodes where category='Front End'>0)) and (d.skill_code&(select code from skillcodes where name='Python')>0) then 'A'
when d.skill_code&(select code from skillcodes where name='C#'>0) then 'B'
when d.skill_code&(select sum(code) from skillcodes where category='Front End')>0 then 'C'
else 'No'
end as grade, d.id as id
from DEVELOPERS d)

select grade,d.id as id,email from new_table n,developers d
where n.id=d.id and grade != 'No'
order by grade asc, id asc


