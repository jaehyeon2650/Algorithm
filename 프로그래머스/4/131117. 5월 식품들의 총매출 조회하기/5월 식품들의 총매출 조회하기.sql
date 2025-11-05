select fd.product_id, product_name, price * total as total_sales from FOOD_PRODUCT fd
right join (
select product_id, sum(amount) as total from FOOD_ORDER
where year(produce_date) = 2022 and month(produce_date) = 5
group by product_id
) as fo
on fd.product_id = fo.product_id
order by total_sales desc, product_id asc
