-- 코드를 입력하세요
select year(sales_date) as year, month(sales_date) as month, gender, count(distinct u.user_id) as users from user_info u, online_sale o
where u.user_id = o.user_id and gender is not null
group by year(sales_date), month(sales_date), gender
order by year asc, month asc, gender asc