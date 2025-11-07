-- 코드를 입력하세요
select 
    history_id, 
    truncate((daily_fee * diff * (100-discount_rate)/100), 0) as fee
from
(select 
    history_id,
    daily_fee,
    case 
        when datediff(end_date, start_date)+1 >= 90 then (select discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where car_type = '트럭' and duration_type like "%90%")
        when datediff(end_date, start_date)+1 >= 30 then (select discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where car_type = '트럭' and duration_type like "%30%")
        when datediff(end_date, start_date)+1 >= 7 then (select discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where car_type = '트럭' and duration_type like "%7%")
        else 0
    end as discount_rate,
    datediff(end_date, start_date) + 1 as diff
from CAR_RENTAL_COMPANY_CAR c, CAR_RENTAL_COMPANY_RENTAL_HISTORY ch
where c.car_id = ch.car_id and car_type = '트럭') as history
order by fee desc, history_id desc



