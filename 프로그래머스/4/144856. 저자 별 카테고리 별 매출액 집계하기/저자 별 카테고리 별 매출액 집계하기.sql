-- 코드를 입력하세요
with new_table as (select b.category,b.author_id,sum(sales*price) as total_sales from book_sales bs, book b
where b.book_id=bs.book_id and month(bs.sales_date)=1 and year(bs.sales_date)=2022
group by b.book_id,b.category, b.author_id)

select a.author_id as author_id, author_name, category, sum(total_sales) as total_sales from new_table t,author a
where t.author_id=a.author_id
group by a.author_id, author_name, category
order by author_id asc, category desc






