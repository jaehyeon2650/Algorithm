-- 코드를 입력하세요
set @h = -1;

select (@h := @h +1) as hour,
    (select count(*) from animal_outs where hour(datetime) = @h) as count
    from ANIMAL_OUTS
where @h <23