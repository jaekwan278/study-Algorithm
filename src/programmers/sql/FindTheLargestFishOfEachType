물고기 종류 별 대어 찾기

-- 코드를 작성해주세요

WITH max AS (
    SELECT fish_type, MAX(length) AS length
    FROM fish_info
    GROUP BY fish_type
)
SELECT i.id, n.fish_name, i.length
FROM fish_info i
INNER JOIN max m ON m.fish_type = i.fish_type AND m.length = i.length
INNER JOIN fish_name_info n ON n.fish_type = m.fish_type
ORDER BY i.id ASC;

SELECT i.id, n.fish_name, i.length
FROM fish_info i
INNER JOIN fish_name_info n ON n.fish_type = i.fish_type
WHERE (i.fish_type, i.length) IN
(
    SELECT fish_type, MAX(length)
    FROM fish_info
    GROUP BY fish_type
)
ORDER BY i.id ASC;



