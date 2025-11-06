select
    year(sales_date) as year,
    month(sales_date) as month,
    count(distinct ui.user_id) as purchased_users,
    round(count(distinct ui.user_id)/(select count(*) from USER_INFO where year(joined) = 2021) ,1) as purchased_ratio
from USER_INFO ui
left join ONLINE_SALE os on ui.user_id = os.user_id
where year(joined) = 2021
group by year(sales_date), month(sales_date)
having year is not null and month is not null
order by year asc, month asc


