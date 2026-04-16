// 입양 시각 구하기(2)

-- 코드를 입력하세요
WITH RECURSIVE hours AS (
    SELECT 0 AS hour
    UNION ALL
    SELECT hour + 1 FROM hours WHERE hour < 23
)
SELECT h.hour AS HOUR, COUNT(o.id) AS COUNT
FROM hours h
LEFT JOIN animal_outs o ON HOUR(o.datetime) = h.hour
GROUP BY h.hour
ORDER BY h.hour;

-- 코드를 입력하세요
SELECT h.hour, COUNT(o.animal_id) AS count
FROM (
    SELECT LEVEL - 1 AS hour
    FROM dual
    CONNECT BY LEVEL <= 24
) h
LEFT JOIN animal_outs o
    ON o.datetime >= TRUNC(o.datetime) + h.hour / 24
    AND o.datetime < TRUNC(o.datetime) + (h.hour+1) / 24
GROUP BY h.hour
ORDER BY h.hour;
