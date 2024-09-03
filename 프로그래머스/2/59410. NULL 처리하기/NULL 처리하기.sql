-- 코드를 입력하세요
SELECT animal_type, if(name is NULL,"No name",name) as name, sex_upon_intake
from animal_ins