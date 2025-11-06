-- 코드를 입력하세요
select ao.animal_id, ao.animal_type, ao.name from ANIMAL_INS ai, ANIMAL_OUTS ao
where 
    ai.animal_id = ao.animal_id
    and SEX_UPON_INTAKE like "%Intact%"
    and (SEX_UPON_OUTCOME like "%Spayed%" or SEX_UPON_OUTCOME like "%Neutered%")
order by ao.animal_id asc