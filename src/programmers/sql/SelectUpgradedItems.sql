// 업그레이드 된 아이템 구하기

-- 코드를 작성해주세요
WITH target AS
(
    SELECT t.item_id
    FROM item_info i
    INNER JOIN item_tree t ON t.parent_item_id = i.item_id
    WHERE rarity = 'RARE'
)
SELECT t.item_id, i.item_name, i.rarity
FROM target t
INNER JOIN item_info i ON i.item_id = t.item_id
ORDER BY t.item_id DESC;

-- 코드를 작성해주세요
SELECT t.item_id, i.item_name, i.rarity
FROM
(
    SELECT t.item_id
    FROM item_info i
    INNER JOIN item_tree t ON t.parent_item_id = i.item_id
    WHERE rarity = 'RARE'
) t
INNER JOIN item_info i ON i.item_id = t.item_id
ORDER BY t.item_id DESC;

-- 코드를 작성해주세요
SELECT t.item_id, child.item_name, child.rarity
FROM item_info parent
INNER JOIN item_tree t ON t.parent_item_id = parent.item_id AND parent.rarity = 'RARE'
INNER JOIN item_info child ON t.item_id = child.item_id
ORDER BY t.item_id DESC;