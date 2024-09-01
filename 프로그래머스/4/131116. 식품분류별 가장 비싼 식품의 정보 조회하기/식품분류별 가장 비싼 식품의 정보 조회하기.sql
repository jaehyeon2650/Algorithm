-- 코드를 입력하세요
with max_table as(
    SELECT MAX(price) as max_price, category 
    FROM food_product
    WHERE category IN ("과자","국","김치","식용유")
    GROUP BY category
)

select f.category as category, f.price as max_price, f.product_name as product_name
from food_product f, max_table m
where f.category=m.category and f.price=m.max_price
order by max_price desc
