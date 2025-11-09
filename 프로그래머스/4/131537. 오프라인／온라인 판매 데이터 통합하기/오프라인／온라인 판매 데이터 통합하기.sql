-- 코드를 입력하세요
with a as(SELECT date_format(sales_date,"%Y-%m-%d") as sales_date, product_id, user_id, sales_amount FROM ONLINE_SALE
WHERE year(sales_date) = 2022 and month(sales_date) = 3

union all

select date_format(sales_date,"%Y-%m-%d") as sales_date, product_id, NULL as user_id ,sales_amount from OFFLINE_SALE
WHERE year(sales_date) = 2022 and month(sales_date) = 3)

select * from a
order by sales_date asc, product_id asc, user_id asc