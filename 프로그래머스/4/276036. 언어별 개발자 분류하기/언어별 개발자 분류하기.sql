-- 코드를 작성해주세요
select 
    case 
    when ((select bit_or(code) from skillcodes where category = 'Front End') & skill_code )>0 && (((select code from skillcodes where name = 'Python') & skill_code) >0) then 'A'
    when ((select code from skillcodes where name = 'C#')&skill_code)>0 then 'B'
    when ((select bit_or(code) from skillcodes where category = 'Front End') & skill_code )>0 then 'C'
    else 'NO'
    end as grade, id, email
from DEVELOPERS 
HAVING grade != 'NO'
order by grade asc, id asc
