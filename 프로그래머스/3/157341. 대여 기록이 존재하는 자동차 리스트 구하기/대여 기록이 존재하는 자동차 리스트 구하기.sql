-- 코드를 입력하세요
select distinct h.car_id from CAR_RENTAL_COMPANY_CAR c, CAR_RENTAL_COMPANY_RENTAL_HISTORY h
where c.car_id = h.car_id and car_type = '세단' and month(start_date)=10
order by car_id desc