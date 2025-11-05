-- 코드를 작성해주세요
select 
    he.emp_no,
    emp_name,
    case 
        when avg(score) >= 96 then 'S'
        when avg(score) >= 90 then 'A'
        when avg(score) >= 80 then 'B'
        else 'C'
        end as grade,
    case 
        when avg(score) >= 96 then sal * 0.2
        when avg(score) >= 90 then sal * 0.15
        when avg(score) >= 80 then sal * 0.1
        else 0
        end as bonus
        from HR_EMPLOYEES he, HR_GRADE hg 
where he.emp_no = hg.emp_no
group by he.emp_no, emp_name
order by emp_no asc