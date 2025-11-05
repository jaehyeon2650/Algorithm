# with car_list as (select car_id from CAR_RENTAL_COMPANY_CAR
# where car_id not in 
# (select distinct(cr.car_id) from CAR_RENTAL_COMPANY_CAR cr
# inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY ch on cr.car_id = ch.car_id
# where (car_type = 'SUV' or car_type = '세단')
#     and ((start_date >= '2022-11-01' and start_date <= '2022-11-30')
#         or
#         (end_date >= '2022-11-01' and start_date <='2022-11-30'))))
        
select 
    car_id, 
    car_type,
    floor((daily_fee * (100-(select discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN cp where cp.car_type = c.car_type and duration_type = '30일 이상'))/100) * 30) as fee
from CAR_RENTAL_COMPANY_CAR c
where c.car_id not in (
    select distinct(cr.car_id) from CAR_RENTAL_COMPANY_CAR cr
    inner join CAR_RENTAL_COMPANY_RENTAL_HISTORY ch on cr.car_id = ch.car_id
    where
        ((start_date >= '2022-11-01' and start_date <= '2022-11-30')
            or
            (end_date >= '2022-11-01' and start_date <='2022-11-30'))
    )
    and (car_type = 'SUV' or car_type = '세단')
having fee >= 500000 and fee <2000000
order by fee desc, car_type asc, car_id desc
    

 