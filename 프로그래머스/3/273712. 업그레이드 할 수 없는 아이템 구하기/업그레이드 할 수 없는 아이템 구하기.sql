-- 코드를 작성해주세요
select item_id, item_name, rarity 
from item_info i
where not exists (
    select 1 from item_tree it
    where it.parent_item_id = i.item_id
)
order by item_id desc