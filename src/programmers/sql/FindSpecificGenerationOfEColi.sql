특정 세대의 대장균 찾기

-- 코드를 작성해주세요
SELECT DISTINCT c.id
FROM ecoli_data a
INNER JOIN ecoli_data b ON b.parent_id = a.id AND a.parent_id IS NULL
INNER JOIN ecoli_data c ON c.parent_id = b.id
ORDER BY c.id ASC;

-- RECURSIVE
WITH RECURSIVE tree AS (
    SELECT id, parent_id, 1 AS depth
    FROM ecoli_data
    WHERE parent_id IS NULL

    UNION ALL

    SELECT e.id, e.parent_id, t.depth + 1
    FROM ecoli_data e
    INNER JOIN tree t ON e.parent_id = t.id
)
SELECT id
FROM tree
WHERE depth = 3
ORDER BY id ASC;

-- EXISTS
SELECT c.id
FROM ecoli_data c
WHERE EXISTS(
    SELECT 1
    FROM ecoli_data b
    INNER JOIN ecoli_data a ON a.id = b.parent_id
    WHERE b.id = c.parent_id
        AND a.parent_id IS NULL
)
ORDER BY c.id ASC;
