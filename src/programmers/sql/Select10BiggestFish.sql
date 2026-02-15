가장 큰 물고기 10마리 구하기

-- 코드를 작성해주세요

SELECT id,
    CASE
        WHEN length IS NULL THEN 10
        ELSE length
    END AS length
FROM fish_info
ORDER BY length DESC, id
LIMIT 10;

SELECT id, length
FROM fish_info
WHERE length IS NOT NULL
ORDER BY length DESC, id
LIMIT 10;