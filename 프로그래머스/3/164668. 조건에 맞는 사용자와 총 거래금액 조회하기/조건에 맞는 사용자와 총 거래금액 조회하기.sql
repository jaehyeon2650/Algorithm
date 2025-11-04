-- 코드를 입력하세요
select user_id, nickname, sum(price) as total_sales from USED_GOODS_BOARD b, USED_GOODS_USER u
where b.writer_id = u.user_id and status = 'DONE'
group by user_id, nickname
having sum(price) >= 700000
order by total_sales asc

