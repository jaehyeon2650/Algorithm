-- 코드를 입력하세요
select cart_id from (select distinct cart_id from CART_PRODUCTS
where name = 'Milk'
INTERSECT
select distinct cart_id from CART_PRODUCTS
where name = 'Yogurt') as temp
order by cart_id asc