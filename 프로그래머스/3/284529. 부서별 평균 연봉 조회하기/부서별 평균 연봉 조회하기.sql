-- 코드를 작성해주세요
select d.dept_id as dept_id,d.dept_name_en as dept_name_en,round(avg(e.sal),0) as avg_sal
from hr_department d, hr_employees e
where d.dept_id=e.dept_id
group by d.dept_id, d.dept_name_en
order by avg_sal desc