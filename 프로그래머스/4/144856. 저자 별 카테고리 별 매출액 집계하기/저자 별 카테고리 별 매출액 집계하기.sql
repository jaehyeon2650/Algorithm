-- 코드를 입력하세요
# select b.author_id, category from book b, author a
# where b.author_id = a.author_id
# group by b.author_id, category

# with new_table as (select book_id, category, author_id, price * (select sum(sales) from book_sales bs
# where year(sales_date) = 2022 and month(sales_date) = 1 and bs.book_id = b.book_id) as total from book b)

# select n.author_id, a.author_name, n.category, sum(total) as total_sales from new_table n, author a
# where n.author_id = a.author_id
# group by n.author_id, a.author_name, n.category
# order by author_id desc, category desc

# select book_id, category, author_id, price * (select sum(sales) from book_sales bs
# where year(sales_date) = 2022 and month(sales_date) = 1 and bs.book_id = b.book_id) as total from book b

select a.author_id, a.author_name, category, sum(price*sales) as total_sales from book b, author a, book_sales bs
where b.book_id = bs.book_id and b.author_id = a.author_id
and year(sales_date) = 2022 and month(sales_date) = 1
group by a.author_id, a.author_name, b.category
order by author_id asc, category desc


