-- 코드를 입력하세요
select f.flavor from first_half f,
(select ju.flavor, sum(total_order) as total from july ju group by ju.flavor) j
where f.flavor = j.flavor
order by total_order + total desc
limit 3