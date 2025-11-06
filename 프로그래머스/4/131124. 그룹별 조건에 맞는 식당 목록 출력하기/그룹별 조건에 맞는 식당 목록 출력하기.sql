-- 코드를 입력하세요
select member_name, review_text, date_format(review_date,"%Y-%m-%d") from MEMBER_PROFILE mp
left join REST_REVIEW pr on mp.member_id = pr.member_id
where pr.member_id in(
    select member_id from REST_REVIEW
    group by member_id
    having count(*) = (select max(counts) from (select count(*) as counts from REST_REVIEW group by member_id) as temp)
    )
order by review_date asc, review_text asc
