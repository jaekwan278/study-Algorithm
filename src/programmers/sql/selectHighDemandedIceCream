주문량이 많은 아이스크림들 조회하기

-- 코드를 입력하세요
WITH tmp AS (
    SELECT flavor, total_order AS cnt
    FROM first_half

    UNION ALL

    SELECT flavor, total_order AS cnt
    FROM july
)
SELECT flavor
FROM tmp
GROUP BY flavor
ORDER BY SUM(cnt) DESC
LIMIT 3;
