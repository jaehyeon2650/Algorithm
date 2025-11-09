-- 코드를 입력하세요
SELECT ri.rest_id, rest_name, food_type, favorites, address, round(avg(review_score),2) as score from REST_INFO ri
right join REST_REVIEW rr on ri.rest_id = rr.rest_id
where address like "서울%"
group by ri.rest_id
order by score desc, favorites desc