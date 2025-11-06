-- 코드를 작성해주세요
select id, email, first_name, last_name from DEVELOPERS
where skill_code & (select bit_or(code) as front_code from skillcodes where category = 'Front End') > 0
order by id asc