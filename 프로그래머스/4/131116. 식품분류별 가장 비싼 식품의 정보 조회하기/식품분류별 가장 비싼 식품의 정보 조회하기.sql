-- 코드를 입력하세요
select category, price as max_price, product_name from food_product fp
where category in ('과자','국','김치','식용유') 
and price = (select max(price) from food_product f where f.category = fp.category)
order by max_price desc