-- 코드를 입력하세요
select concat("/home/grep/src/",board_id,"/",file_id,file_name,file_ext) as file_path
from USED_GOODS_FILE
where board_id = (select board_id from USED_GOODS_BOARD
where views = (SELECT max(views) from USED_GOODS_BOARD))
order by file_id desc

