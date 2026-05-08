// 업그레이드 할 수 없는 아이템 구하기

SELECT i.item_id, i.item_name, i.rarity
FROM item_info i
WHERE NOT EXISTS(
    SELECT 1
    FROM item_tree t
    WHERE t.parent_item_id = i.item_id
)
ORDER BY i.item_id DESC;

// NOT EXISTS : ANTI JOIN 사용.
// EXISTS : SEMI JOIN 사용.